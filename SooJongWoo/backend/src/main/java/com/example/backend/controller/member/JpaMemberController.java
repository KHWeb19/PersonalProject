package com.example.backend.controller.member;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.controller.member.request.UserRequest;
import com.example.backend.controller.session.UserInfo;
import com.example.backend.entity.jpa.Member;
import com.example.backend.repository.jpa.JpaMemberRepository;
import com.example.backend.service.jpa.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaMemberController {

    private UserInfo info;

    private Member memberId;

    @Autowired
    private JpaMemberService service;

    @Autowired
    private JpaMemberRepository memberRepository;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<MemberRequest> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest,
            HttpServletRequest request) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword()  + ", " + memberRequest.getPasswordReInput());


        boolean ableId = service.duplicateCheck(memberRequest);

        if (memberRequest.getPassword().equals(memberRequest.getPasswordReInput())) {
            if(ableId){
                log.info("able id");
                log.info("register Success");
                service.register(memberRequest);
                log.info(memberRequest.getAuth(),memberRequest.getUserName());
                return new ResponseEntity<MemberRequest>(memberRequest,HttpStatus.OK);
            } else {
                log.info("unable id");
                return null;
            }
        } else {
            log.info("register Fail");
            return null;
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Member> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setUserId(memberRequest.getUserId());
            service.user(memberRequest.getUserId());


            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);

        } else {
            log.info("Login Fail");
            info = null;
            return null;
        }
        return new ResponseEntity<>(service.user(memberRequest.getUserId()), HttpStatus.OK);
    }


    @GetMapping("/lists")
    public ResponseEntity<Member> getUsers (HttpServletRequest request,
                                            @RequestParam("userId") String userId, UserRequest userRequest) throws Exception {

        log.info("getLists(): " + service.user(userId));
        return new ResponseEntity<>(service.user(userId), HttpStatus.OK);


    }

    // 로그인 세션
    @PostMapping("/needSession")
    public ResponseEntity<UserInfo> postNeedSession(HttpServletRequest request) throws Exception {

        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getUserId());
            return new ResponseEntity<UserInfo>(info,HttpStatus.OK);
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    // 세션 로그아웃
    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<Member> userRead(@PathVariable("memberNo") Long memberNo) throws Exception {
        Member member = service.userRead(memberNo);

        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @PutMapping("/{memberNo}")
    public ResponseEntity<MemberRequest> userModify(@PathVariable("memberNo") Long memberNo,
                                                    @Validated @RequestBody MemberRequest memberRequest ) throws Exception {


        Optional<Member> modifyUser = memberRepository.findById(memberNo);

        modifyUser.ifPresent( changeUser ->{
            changeUser.setUserPhone(memberRequest.getUserPhone());
            memberRequest.setMemberNo(memberNo);
            memberRepository.save(changeUser);
        });

        return new ResponseEntity<>(memberRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> removeUser(@PathVariable("memberNo") Long memberNo) throws Exception {
        service.removeUser(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
