package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.request.MemberRequest;
import com.example.demo.service.join.JoinMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/join")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class  JoinMemberController {

    @Autowired
    private JoinMemberService service;

    @PostMapping("/register")
    public Member register (@Validated @RequestBody Member member, HttpSession session, HttpServletRequest request){
        log.info("register" + member);

        HttpSession userSession = request.getSession();

        service.register(member, userSession);

        System.out.println("register Page ");
        System.out.println("session id : " + session.getId());

        return member;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> checkId(@PathVariable String id){
        log.info("checkId()");

        boolean check = service.checkIdDuplicate(id);
        log.info(String.valueOf(check));
        return ResponseEntity.ok(service.checkIdDuplicate(id));
    }

    @PostMapping("/login")
    public MemberRequest memberLogin(@RequestBody MemberRequest memberRequest){
        log.info("memberLogin" + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }

    @PostMapping("/loginSuccess/{id}")
    public Member loginMember(@PathVariable("id") String id) {
        log.info("loginMember :" + id);

        //return service.read(id);
        return null;
    }
}
