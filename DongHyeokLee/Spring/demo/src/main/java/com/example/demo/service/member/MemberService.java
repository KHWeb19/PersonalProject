package com.example.demo.service.member;

import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.duplication.DuplicationCheck;
import com.example.demo.entitiy.member.MemberInfo;

import java.util.List;

public interface MemberService {
    public DuplicationCheck register (MemberRequest memberRequest);
    public List<MemberInfo> list();
    public MemberRequest login (MemberRequest memberRequest);
    public void modify (MemberRequest memberRequest);
    public void remove (MemberInfo member);
}
