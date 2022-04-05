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

    // 회원가입
    @PostMapping("/register")
    public Member register (@Validated @RequestBody Member member) {
        log.info ("member register request from vue" + member);

        service.register(member);

        return member;
    }

    // 로그인
    @PostMapping ("/login")
    public MemberRequest login (@RequestBody MemberRequest memberRequest){
        log.info ("login(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info ("로그인 성공!");
        } else {
            log.info ("로그인 실패!");
        }

        return memberResponse;
    }

    // 회원정보 읽기
    @GetMapping ("/{memberNo}")
    public Member read (@PathVariable("memberNo") Long memberNo){
        log.info ("read:" + memberNo);

        return service.read(memberNo);
    }

    // 회원정보 수정
    @PutMapping ("/modify")
    public MemberRequest modify (@RequestBody Member member){
        log.info ("modify(): " + member);

        service.modify(member);

        return new MemberRequest();

    }


}
