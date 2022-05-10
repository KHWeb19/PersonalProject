package com.example.demo.Controller;

import com.example.demo.Controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/member")
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

    // 프로필 변경
    @PutMapping("/modify/{memberNo}")
    public Member modify (
            @PathVariable("memberNo") Long memberNo,
            @RequestBody Member member) {
        log.info("modify(): " + member);

        member.setMemberNo(Long.valueOf(memberNo));
        service.modify(member);

        return member;
    }

}
