package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Member;

import java.util.List;

public interface MemberService {
    public void register (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
    List<Member> findBusiness();
}
