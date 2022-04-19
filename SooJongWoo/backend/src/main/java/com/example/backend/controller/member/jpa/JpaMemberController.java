package com.example.backend.controller.member.jpa;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.service.jpa.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaMemberController {

    @Autowired
    private JpaMemberService service;

    @PostMapping("/register")
    public ResponseEntity<MemberRequest> jpaRegister (@Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " +memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " + (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " + memberRequest.getPasswordReInput());

            boolean ableId = service.duplicateCheck(memberRequest);

        if (memberRequest.getPassword().equals(memberRequest.getPasswordReInput())) {
            if (ableId) {
                log.info("able id");
                log.info("register Success");
                service.register(memberRequest);
                log.info(memberRequest.getAuth(), memberRequest.getUserName());
                return new ResponseEntity<MemberRequest>(memberRequest, HttpStatus.OK);
            } else {
                log.info("unable id");
                return null;
            }
        } else {
            log.info("register Fail");
            return null;
        }
    }
}
