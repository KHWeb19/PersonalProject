package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Member;

import java.util.List;

public interface MemberService {
    public List<Member> list ();
    public List<Member> search(String keyWord);
    public Member register (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
    public MemberRequest forget (MemberRequest memberRequest);
    public Member read (Long memberNo);
    public void profile (Member member);
    public void modify (Member member);
    public void remove (Long memberNo);
}
