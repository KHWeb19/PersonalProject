package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.Member;

public interface MemberService {
    public void register(Member member);
    public Member login (String auth, String id, String pw);
}
