package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberservice;

    @PostMapping("/register")
    public void jpaMemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("register request from vue:() " + memberRequest);

        memberservice.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest jpaMemberLogin(@RequestBody MemberRequest memberRequest) {
        log.info("login request from vue:() " + memberRequest);

        MemberRequest memberResponse = memberservice.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }

    @GetMapping("/{memberNo}")
    public Member jpaMemberRead(
            @PathVariable("memberNo") Long memberNo) {
        log.info("Member information Read()" + memberNo);

        return memberservice.read(memberNo);
    }
}

