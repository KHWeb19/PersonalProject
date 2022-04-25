package com.example.demo.controller.Member;

import com.example.demo.controller.Member.response.MemberResponse;
import com.example.demo.entity.Member.Member;
import com.example.demo.service.Member.MemberManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
