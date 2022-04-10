package com.example.demo.controller.personalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.service.presonalProject.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register (@Validated @RequestBody Member member) {
        log.info("register request from vue: " + member);

        service.register(member);;
    }

    @PostMapping("/login")
    public Boolean login(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("member Login(): " + memberRequest);

        return service.login(memberRequest);

    }

}
