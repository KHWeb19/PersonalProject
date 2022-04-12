package com.example.demo.controller.personalProject;

import com.example.demo.controller.request.MemberDto;
import com.example.demo.controller.session.UserInfo;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.service.presonalProject.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Member register() " + memberDto);

        Member member = service.register(memberDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Member member, HttpServletRequest request) throws Exception {
        log.info("Member login()");

        Boolean isSuccess = service.login(member);

        if(isSuccess) {
            info = new UserInfo();
            info.setId(member.getId());

            session = request.getSession();
            session.setAttribute("member", info);

            log.info("Login Success");
        } else {
            info = null;

            log.info("Login fail");
        }

        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if(obj != null) {
            isLogin = service.validationId(info.getId());
        } else {
            isLogin = false;
        }

        log.info(String.valueOf(isLogin));

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        log.info("Member logout");

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
}
