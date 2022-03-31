package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.join.JoinMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/join")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JoinMemberController {

    @Autowired
    private JoinMemberService service;

    @PostMapping("/register")
    public Member register (@Validated @RequestBody Member member){
        log.info("register" + member);

        service.register(member);

        return member;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> checkId(@PathVariable String id){
        log.info("checkId()");

        boolean check = service.checkIdDuplicate(id);
        log.info(String.valueOf(check));
        return ResponseEntity.ok(service.checkIdDuplicate(id));
    }
}
