package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void register (@Validated @RequestBody MemberRequest memberRequest){
        log.info("register" + memberRequest);
        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin - " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("login success!");
        } else {
            log.info("login fail!");
        }

        return memberResponse;
    }
//
//    @GetMapping("/mypage")
//    public Member read (@AuthenticationPrincipal Member currentMember,  Model model){
//        log.info("user detail" + currentMember);
//        return service.read(currentMember.memberNo);
//
//    }


}
