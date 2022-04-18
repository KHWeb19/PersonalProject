package com.example.demo.service.Member;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member.Member;

import java.util.List;


public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest checkUserIdDuplication (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
    public List<Member> list();
    public Member readPersonalInform (Long memberNo);
    public void modifyPersonalInform (Member member);
    public void remove (Long memberNo);
}
