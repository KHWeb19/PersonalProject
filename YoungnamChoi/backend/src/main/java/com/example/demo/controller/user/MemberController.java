package com.example.demo.controller.user;


import com.example.demo.controller.user.session.UserInfo;
import com.example.demo.entity.user.Member;
import com.example.demo.request.MemberDto;
import com.example.demo.service.user.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> signup(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Member Signup");

        Member member = service.signup(memberDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Member member, HttpServletRequest request) throws Exception {
        log.info("Member Login");

        Boolean isSuccess = service.login(member);

        if (isSuccess) {
            info = new UserInfo();
            info.setId(member.getId());

            session = request.getSession();
            session.setAttribute("member", info);

            log.info("Login Success");
        } else {
            info = null;

            log.info("Login Failure");
        }

        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            isLogin = service.validationId(info.getId());
        } else {
            isLogin = false;
        }
        log.info(String.valueOf(isLogin));

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }



}













