package com.example.backend.controller.member;

import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.service.member.MemberManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/memberManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberManagerController {

    @Autowired
    private MemberManagerService service;

    //member와 member_auth 따로 설정해줌
    @GetMapping("/list")
    public List<Member> registerMemberList(){
        log.info("registerMemberList()");

        return service.list();
    }

    @GetMapping("/authList")
    public List<MemberAuth> registerMemberAuthList(){
        log.info("registerMemberAuthList()");

        return service.authList();
    }

    @GetMapping("/member/{memberNo}")
    public Member memberRead(@PathVariable("memberNo") Long memberNo){
        log.info("memberRead()");

        return service.memberRead(memberNo);
    }

    @GetMapping("/memberAuth/{memberNo}")
    public MemberAuth memberAuthRead(@PathVariable("memberNo") Long memberNo){
        log.info("memberAuthRead()");

        return service.memberAuthRead(memberNo);
    }

    @PutMapping("/{memberNo}")
    public MemberAuth memberAuthModify(@PathVariable("memberNo") Long memberNo,@RequestBody MemberAuth memberAuth){
        log.info("memberAuthModify() " +memberAuth);

        memberAuth.setMemberNo(memberNo);
        service.modify(memberAuth);

        return memberAuth;
    }

    @DeleteMapping("/{memberNo}")
    public void memberRemove(@PathVariable("memberNo")Long memberNo){
        log.info("memberRemove() " +memberNo);

        service.remove(memberNo);
    }

}
