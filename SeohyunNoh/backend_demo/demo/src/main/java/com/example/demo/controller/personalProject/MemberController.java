package com.example.demo.controller.personalProject;

import com.example.demo.entity.personalProject.Member;
import com.example.demo.service.presonalProject.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
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
    public void register(@Validated @RequestBody Member member){
        log.info("memberRegister(): " + member);

        service.register(member);
    }

    @PostMapping("/login")
    public Member login(@RequestBody Member member) {
        log.info ("login(): " + member);

        Member loginMember = service.login(member.getAuth(), member.getId(), member.getPw());

        if(loginMember == null) {
            log.info ("권한 / 아이디 / 비밀번호 가 일치하지 않습니다");
            return null;
        }

        return loginMember;

    }

}
