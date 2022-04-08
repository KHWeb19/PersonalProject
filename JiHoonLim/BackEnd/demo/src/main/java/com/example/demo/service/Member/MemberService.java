package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.Member.Member;

import java.util.List;

public interface MemberService {
    public List<Member> list();
    public Member read(Long memberNo);
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest);
    public Boolean checkDuplicateId(String id);
    public Boolean checkDuplicateNickName(String nickName);
    public Boolean checkDuplicateEmail(String email);
    public List findUserId(String email);
    public Boolean idMatchEmail(MemberRequest memberRequest);
    public void modifyPw(String id, String pw);
    public void modifyNickName(Long memberNo, String nickName);
    public void modifyEmail(Long memberNo, String email);
}
