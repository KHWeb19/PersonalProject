package com.example.backend.controller;

import com.example.backend.entity.Member;
import com.example.backend.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister():" +
                memberRequest.getId() + ", " +
                memberRequest.getPw() + ", " +
                (memberRequest.getAuth().equals("관리자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("memberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }

    @GetMapping("/checkBusiness")
    public List<MemberResponse> checkBusinessMember () {
        log.info("checkBusiness() ===> findBusinessMember!!!");

        List<Member> businessMember = service.findBusiness();
        List<MemberResponse> responses = new ArrayList<>();

        for (Member member : businessMember) {
            responses.add(new MemberResponse(member.getMemberId()));
        }

        return responses;
    }
}
