package com.example.backend.controller;

import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        log.info("Users page");
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        log.info("Roles page");
        return new ResponseEntity<>(userService.getRoles(), HttpStatus.OK);
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }

    @PostMapping("/role/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRoleForm userRoleForm){
        userService.addRoleToUser(userRoleForm.getUsername(), userRoleForm.getRolename());
        return ResponseEntity.ok().build();
    }

}
@Data
class UserRoleForm{
    private String username;
    private String rolename;
}