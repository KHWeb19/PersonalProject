package com.example.demo.controller.personalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.service.presonalProject.MemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/memberAuth")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberAuthController {

    @Autowired
    private MemberAuthService service;

    @PostMapping("/register")
    public void memberAuthRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("memberAuthRegister() : " + memberRequest.getId() + ", " + memberRequest.getPw() + ", "
                    + (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL"
                        : memberRequest.getAuth().equals("판매자") ? "ROLE_SELLER" : "ROLE_ADMINISTRATOR"));

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("memberLogin() : " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if(memberResponse != null) {
            log.info("로그인 성공");
        } else {
            log.info("로그인 실패 ");
        }

        return memberResponse;
    }
}
