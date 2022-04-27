package com.example.backend.controller;

import com.example.backend.entity.Role;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {
    private final UserService userService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        log.info("Roles page");
        return new ResponseEntity<>(userService.getRoles(), HttpStatus.OK);
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }

}
