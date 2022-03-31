package com.example.demo.service.member;

import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entitiy.member.Member;

import java.util.List;

public interface MemberService {
    public void register (MemberRequest memberRequest);
    public List<Member> list();
    public MemberRequest login (MemberRequest memberRequest);

}
