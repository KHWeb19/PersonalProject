package com.example.backend.service.jpa;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.entity.jpa.Member;

import java.util.Optional;

public interface JpaMemberService {

    public void register(MemberRequest memberRequest) throws Exception;

    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userId) throws Exception;

    public Optional<Member> findByAuth(Long memberNo) throws Exception;;

    public Member user(String userId) throws Exception;

    public Member userRead(Long memberNo) throws Exception;

    public void removeUser(Long memberNo) throws Exception;


}
