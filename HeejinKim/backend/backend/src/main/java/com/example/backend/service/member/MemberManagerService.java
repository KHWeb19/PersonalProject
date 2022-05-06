package com.example.backend.service.member;

import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;

import java.util.List;

public interface MemberManagerService {
    public List<Member> list();
    public List<MemberAuth> authList();
    public Member memberRead(Long memberNo);
    public MemberAuth memberAuthRead(Long memberNo);
    public void modify (MemberAuth memberAuth);
    public void remove (Long memberNo);
}
