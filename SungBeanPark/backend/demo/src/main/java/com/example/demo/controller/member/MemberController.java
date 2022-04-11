package com.example.demo.controller.member;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders ="*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void registerMember(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister()" + memberRequest.getId() + ", " + memberRequest.getPw() + ", " + memberRequest.getName() + ", "+ memberRequest.getAuth());

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if(memberResponse != null) {
            log.info("login success!");
        }else{
            log.info("login fail!");
        }

        return memberResponse;
    }
    @GetMapping("/check/{id}")
    public Boolean findId (@PathVariable("id") String id) {
        log.info("findId()" + id);

        Boolean maybeMember = service.checkUserIdValidation(id);

        return maybeMember;
    }
}