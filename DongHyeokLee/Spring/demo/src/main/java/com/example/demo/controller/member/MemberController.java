package com.example.demo.controller.member;


import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entitiy.member.Member;
import com.example.demo.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public void memberRegister(@Validated @RequestBody MemberRequest memberRequest){
        log.info("memberRegister request" + memberRequest);

        memberService.register(memberRequest);
    }

    @GetMapping("/list")
    public List<Member> memberList () {
        log.info("MemberList()");

        return memberService.list();
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest);

        MemberRequest memberResponse = memberService.login(memberRequest);

        if (memberResponse != null){
            log.info("Login Success");
        }else{
            log.info("Login Fail");
        }
        return memberResponse;
    }

    @PutMapping("/modify")
    public Member memberModify (@RequestBody Member member) {
        log.info("memberModify(): " + member);

        log.info(""+ member.getMemberNo());


        memberService.modify(member);

        return member;
    }
}
