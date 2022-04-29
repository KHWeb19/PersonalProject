package com.example.demo.service;

import com.example.demo.controller.Request.MemberRequest;
import com.example.demo.entity.Member;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


public interface MemberService {
    public void register(Member member);

    public MemberRequest login (MemberRequest memberRequest);

    public Member read (Long memberNo);
    public void modify (Member member, @RequestParam(required = false) MultipartFile file) throws Exception;
    public void remove (Long memberNo);


}
