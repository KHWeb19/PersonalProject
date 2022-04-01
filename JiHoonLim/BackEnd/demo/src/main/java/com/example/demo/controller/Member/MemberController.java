package com.example.demo.controller.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.service.Member.MemberService;
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
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest){
        log.info("MemberRegister(): " + memberRequest.getId() + "," +
                memberRequest.getPw() + "," + memberRequest.getNickName() + "," + memberRequest.getEmail() + "," +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        service.register(memberRequest);
    }
}
