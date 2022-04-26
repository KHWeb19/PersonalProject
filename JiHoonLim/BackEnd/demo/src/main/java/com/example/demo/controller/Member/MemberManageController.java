package com.example.demo.controller.Member;

import com.example.demo.controller.Member.response.MemberResponse;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.service.Member.MemberManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/memberManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberManageController {

    @Autowired
    private MemberManageService service;

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
}
