package com.example.demo.controller.memberController;

import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void registerMember (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemeberRegister()" + memberRequest.getEmail() +", "+ memberRequest.getPw() +", "+ memberRequest.getName() +", "+ memberRequest.getAuth());

        service.register(memberRequest);


    }
}
