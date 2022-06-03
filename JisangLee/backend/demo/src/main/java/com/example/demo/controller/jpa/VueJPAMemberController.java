package com.example.demo.controller.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.VueJpaMember;
import com.example.demo.service.jpa.VueJpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vueJpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueJPAMemberController {

    @Autowired
    private VueJpaMemberService service;
    private com.example.demo.controller.jpa.request.MemberRequest MemberRequest;

    @PostMapping("/register")
    public VueJpaMember register (@Validated @RequestBody VueJpaMember member) {
        log.info("register request from vue: " + member);

        service.register(member);

        return member;
    }

    @PostMapping("/login")
    public MemberRequest jpaMemberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("jpaMemberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }
    @GetMapping("/check/{id}")
    public Boolean findId (@PathVariable("id") String id) {
        log.info("findId()" + id);

        Boolean maybeMember = service.checkUserIdValidation(id);

        return maybeMember;
    }
    @GetMapping("/checkto/{nickname}")
    public Boolean findNickname (@PathVariable("nickname") String nickname) {
        log.info("findNickname()" + nickname);

        Boolean maybeMember = service.checkUserNicknameValidation(nickname);

        return maybeMember;
    }

    @PostMapping("/vipjoin")
    public void jpaMemberAuthRegister (@Validated @RequestBody MemberRequest memberRequest) {
        log.info("jpaMemberAuthRegister(): " + memberRequest.getId() + ", " +
                memberRequest.getNickname() + ", " +
                (memberRequest.getAuth().equals("vip") ? "vip" : "general"));

        service.register(memberRequest);
    }
}

