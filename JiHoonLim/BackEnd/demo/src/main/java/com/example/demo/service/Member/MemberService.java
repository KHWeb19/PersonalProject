package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberCart;

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
    public void modifyNoLoginPw(String id, String pw);
    public void modifyLoginPw(Long memberNo, String pw);
    public MemberRequest modifyNickName(Long memberNo, String nickName, MemberRequest memberRequest);
    public MemberRequest modifyEmail(Long memberNo, String email, MemberRequest memberRequest);
    public void deleteMember(Long memberNo);


}
