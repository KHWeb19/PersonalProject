package com.example.demo.controller;

import com.example.demo.controller.Request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public Member register (@Validated @RequestBody Member member) {
        log.info ("member register request from vue" + member);

        service.register(member);

        return member;
    }

//    @PostMapping("/login")
//    public MemberRequest login (@RequestBody MemberRequest memberRequest){
//        log.info ("Login(): " + memberRequest);
//
//        MemberRequest memberResponse = service.login(memberRequest);
//
//        if(memberResponse != null) {
//            log.info ("로그인 성공!");
//        }else {
//            log.info("로그인 실패");
//        }
//        return memberResponse;
//    }
}
