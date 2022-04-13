package com.example.demo.Controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService MemberService;

    @PostMapping("/register")
    public Member register (@Validated @RequestBody Member member) {
        log.info("register request from vue: " + member);

        return member;
    }
}
