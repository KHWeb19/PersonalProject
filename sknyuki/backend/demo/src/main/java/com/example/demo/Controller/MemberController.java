package com.example.demo.Controller;

import com.example.demo.Controller.session.UserInfo;
import com.example.demo.entity.Member;
import com.example.demo.request.MemberDto;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/signup")
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


    @PostMapping("/logout")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        log.info("Member Logout");

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @GetMapping("/mypage/{id}")
    public ResponseEntity<Optional<Member>> userInfo(@PathVariable("id") @RequestBody String id) throws Exception {

        Optional<Member> result = service.userInfo(id);

        return new ResponseEntity<Optional<Member>>(result, HttpStatus.OK);
    }

    @PatchMapping("/mypage/modify/{id}")
    public ResponseEntity<Void> modify(@PathVariable("id") String id, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(id);

        service.modify(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/mypage/remove/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") String id) throws Exception {
        Member member = service.findById(id);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}













