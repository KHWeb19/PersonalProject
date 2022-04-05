package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberRequest;

import java.util.List;

public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest);
    public Boolean checkDuplicateId(String id);
    public Boolean checkDuplicateNickName(String nickName);
    public Boolean checkDuplicateEmail(String email);
    public List findUserId(String email);
}
