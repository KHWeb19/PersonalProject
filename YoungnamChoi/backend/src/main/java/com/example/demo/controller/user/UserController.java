package com.example.demo.controller.user;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public User register (@Validated @RequestBody User member){
        log.info("register request from vue: " + member);

        service.register(member);

        return member;
    }
}
