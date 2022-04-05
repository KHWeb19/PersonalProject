package com.example.demo.service;

import com.example.demo.controller.Request.MemberRequest;
import com.example.demo.entity.Member;


public interface MemberService {
    public void register(Member member);

    public MemberRequest login (MemberRequest memberRequest);

    public Member read (Long memberNo);
    public void modify (Member member);


}
