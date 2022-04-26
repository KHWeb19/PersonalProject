package com.example.demo.service.Member;

import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;

import java.util.List;
public interface MemberManageService {
    public List<Member> list();
    public List<MemberAuth> authList();
    public Member memberRead(Long memberNo);
    public MemberAuth memberAuthRead(Long memberNo);
    public void modify (MemberAuth memberAuth);
    public void remove (Long memberNo);
}
