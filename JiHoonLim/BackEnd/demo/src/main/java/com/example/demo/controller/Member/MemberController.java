package com.example.demo.controller.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.service.Member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest){
        log.info("MemberRegister(): " + memberRequest.getId() + "," +
                memberRequest.getPw() + "," +memberRequest.getName() + "," + memberRequest.getNickName() + "," + memberRequest.getEmail() + "," +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest MemberLogin(@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null){
            log.info("Login Success");
        }else {
            log.info("Login Fail");
        }

        return memberResponse;
    }

    @GetMapping("/checkId/{id}")
    public Boolean checkDuplicateId (@PathVariable("id") String id){
        log.info("checkDuplicateId(): " + id);

        Boolean checkDupId = service.checkDuplicateId(id);

        return checkDupId;
    }

    @GetMapping("/checkNickName/{nickName}")
    public Boolean checkDuplicateNickName (@PathVariable("nickName") String nickName){
        log.info("checkDuplicate(): " + nickName);

        Boolean checkDupNickName = service.checkDuplicateNickName(nickName);

        return checkDupNickName;
    }


}
