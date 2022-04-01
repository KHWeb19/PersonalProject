package com.example.backend.controller;

import com.example.backend.entity.Member;
import com.example.backend.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister():" + "," +
                memberRequest.getName() + ", " +
                memberRequest.getId() + ", " +
                memberRequest.getPw());
        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("memberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }




}
