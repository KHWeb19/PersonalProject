package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Member;
import com.example.backend.entity.jpa.MemberAuth;

import java.util.List;

public interface JpaMemberManagerService {

    public List<Member> list( ) throws Exception;

    public Member read(Long memberNo) throws Exception;

    public void remove(Long memberNo) throws Exception;

    //auth
    public List<MemberAuth> authList( ) throws Exception;
}
