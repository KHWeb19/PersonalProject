package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.service.Member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister(): " + memberRequest.getId() + ", "
                + memberRequest.getPassword() + ", " + memberRequest.getName() + ", "
                + memberRequest.getBirth() + ", " + memberRequest.getPhone() + ", "
                + (memberRequest.getAuth().equals("관리자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        memberService.register(memberRequest);
    }

    @PostMapping("/checkId")
    public Boolean IdCheck(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("Check ID(): " + memberRequest);
        MemberRequest memberRequest1 = memberService.checkUserIdDuplication(memberRequest);

        if (memberRequest1 != null) {
            log.info("success");
            return true;
        } else {
            log.info("fail");
            return false;
        }
    }

    @PostMapping("/login")
    public MemberRequest MemberLogin(@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest.getId() + ", " + memberRequest.getPassword());

        MemberRequest memberResponse = memberService.login(memberRequest);

        if (memberResponse != null) {
            log.info("success");
        } else {
            log.info("fail");
        }

        return memberResponse;
    }

    @GetMapping("/list")
    public List<Member> memberList() {
        log.info("memberList()");

        return memberService.list();
    }
    @GetMapping("/{memberNo}")
    public Member MemberInformRead (@PathVariable("memberNo") Long memberNo) {
        log.info("MyPageRead()");

        return memberService.readPersonalInform(memberNo);
    }

    @PutMapping("/{memberNo}")
    public Member MemberInformModify (@PathVariable("memberNo") Long memberNo,
                                      @RequestBody Member member) {
        log.info("MyPageModify(): " + member);

        member.setMemberNo(Long.valueOf(memberNo));
        memberService.modifyPersonalInform(member);

        return member;
    }

    @DeleteMapping("/{memberNo}")
    public void MemberInformDelete (@PathVariable("memberNo") Long memberNo) {
        log.info("Member Delete()");

        memberService.remove(memberNo);
    }


}
