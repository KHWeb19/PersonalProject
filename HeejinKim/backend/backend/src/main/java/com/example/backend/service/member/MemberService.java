package com.example.backend.service.member;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.entity.Member;

import java.util.List;

public interface MemberService {

    public void register(MemberRequest memberRequest);

    public MemberRequest login (MemberRequest memberRequest);

    public Boolean checkUserIdValidation(String userId);

    //List<Member> find




}
