package com.example.demo.service.member;

import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.entity.member.Member;

public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest) ;
    public Boolean checkUserIdValidation(String id);
    public MemberRequest read(String id);
    public void modify(Member member);
}
