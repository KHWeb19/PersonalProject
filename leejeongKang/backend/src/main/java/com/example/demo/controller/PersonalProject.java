package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PersonalProject {

    @Autowired
    private MemberService memberService;

    @PostMapping("/memberRegister")
    public void MemberRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister(): " + memberRequest.getId() + ", "
                + memberRequest.getPassword() + ", " + (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        memberService.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest);

        MemberRequest memberResponse = memberService.login(memberRequest);

        if(memberResponse != null) {
            log.info("success");
        } else {
            log.info("fail");
        }

        return memberResponse;
    }
}
