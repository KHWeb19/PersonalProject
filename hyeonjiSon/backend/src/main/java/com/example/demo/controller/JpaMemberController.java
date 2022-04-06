package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.service.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaMemberController {

    @Autowired
    private JpaMemberService memberservice;

    @PostMapping("/register")
    public void jpaMemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("register request from vue:() " + memberRequest);

        memberservice.register(memberRequest);
    }
}
