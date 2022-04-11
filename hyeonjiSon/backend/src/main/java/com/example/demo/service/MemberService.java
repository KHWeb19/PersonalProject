package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;

public interface MemberService {
    public void register (MemberRequest memberRequest);

    public MemberRequest login (MemberRequest memberRequest);
    public Member read (Long memberNo);
}
