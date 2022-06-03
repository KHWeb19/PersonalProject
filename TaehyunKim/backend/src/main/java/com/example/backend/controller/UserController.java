package com.example.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        log.info("Users page");
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/admins")
    public ResponseEntity<?> checkAdmin(){
        log.info("Checking Admin");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refreshtoken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Refreshing tokens...");

        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                Cookie refresh_cookie = Arrays.stream(request.getCookies())
                        .filter(cookie -> "refresh_token".equals(cookie.getName()))
                        .findAny()
                        .orElse(null);

                String refresh_token = refresh_cookie.getValue();

                //String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("notlikethis".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);

                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);


                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);

                //tokens.put("refresh_token",  refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            } catch (Exception exception) {
                response.setHeader("error" , exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(Principal principal){
        log.info("GETTING USERNAME");
        return new ResponseEntity<>(userService.getUser(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        log.info("logging out...");

        Cookie cookie = new Cookie("refresh_token", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/emailunique")
    public ResponseEntity<Boolean> emailunique(@RequestParam("email") String email){
        log.info("Is Email unique");

        Boolean isUnique = false;
        Optional<User> userExists = userService.getUserByEmail(email);

        if (userExists.isEmpty()){
            isUnique = true;
        }

        log.info("Email: " + isUnique);

        return new ResponseEntity<Boolean>(isUnique, HttpStatus.OK);
    }

    @GetMapping("/userunique")
    public ResponseEntity<Boolean> usernameunique(@RequestParam("username") String username){
        log.info("Is Username unique");

        Boolean isUnique = false;
        Optional<User> userExists = userService.getUserByUserName(username);

        if (userExists.isEmpty()){
            isUnique = true;
        }

        log.info("Username: " + isUnique);

        return new ResponseEntity<Boolean>(isUnique, HttpStatus.OK);
    }
}
