package com.example.backend.controller.member;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.service.member.MemberService;
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
    private MemberService service;

    @PostMapping("/register")
    public void memberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("memberRegister() : " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                memberRequest.getEmail() +", " +memberRequest.getPasswordCheck() + ", " +
                //(memberRequest.getAuth().equals("개인") ? "개인" : "관리자"));
                (memberRequest.getAuth().equals("INDIVIDUAL") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));
        service.register(memberRequest);

    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("memberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("Login Success");
        } else {
            log.info("Login Failure");
        }

        return memberResponse;
    }
    @GetMapping("/check/{userId}")
    public Boolean findId (@PathVariable("userId") String userId) {
        log.info("findId()" +", " + userId);

        Boolean maybeMember = service.checkUserIdValidation(userId);

        return maybeMember;
    }



}
