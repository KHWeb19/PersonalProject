package com.example.demo.controller.personalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.service.presonalProject.MemberAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/memberAuth")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberAuthController {

    @Autowired
    private MemberAuthService service;

    @PostMapping("/register")
    public void memberAuthRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("memberAuthRegister(): " + memberRequest.getId() + ", " +
                memberRequest.getPw() + ", " +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" :
                        memberRequest.getAuth().equals("판매자") ? "ROLE_SELLER" : "ROLE_MANAGER"));

        service.register(memberRequest);
    }
}
