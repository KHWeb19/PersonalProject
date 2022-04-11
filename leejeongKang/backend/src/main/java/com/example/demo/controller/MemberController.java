package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public void MemberRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister(): " + memberRequest.getId() + ", "
                + memberRequest.getPassword() + ", " +memberRequest.getName() + ", "
                + memberRequest.getBirth() + ", " + memberRequest.getPhone() + ", "
                + (memberRequest.getAuth().equals("관리자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        memberService.register(memberRequest);
    }

    @PostMapping("/checkId")
    public MemberRequest IdCheck (@Validated @RequestBody MemberRequest memberRequest){
        log.info("Check ID(): " + memberRequest);
        MemberRequest memberRequest1 = memberService.checkUserIdDuplication(memberRequest);

        if(memberRequest1 != null) {
            log.info("success");
        } else {
            log.info("fail");
        }

        return memberRequest1;
    }

    @PostMapping("/login")
    public MemberRequest MemberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest.getId() + ", " + memberRequest.getPassword());

        MemberRequest memberResponse = memberService.login(memberRequest);

        if(memberResponse != null) {
            log.info("success");
        } else {
            log.info("fail");
        }

        return memberResponse;
    }

    /*@PostMapping("/mypage/{id}")
    public MemberRequest mypage (@RequestBody MemberRequest memberRequest) {
        log.info("Mypage() :" + memberRequest);


    }*/
}
