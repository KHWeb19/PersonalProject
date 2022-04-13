package com.example.demo.service.user;


import com.example.demo.entity.user.Member;
import com.example.demo.request.MemberDto;

public interface MemberService {
   Member signup(MemberDto memberDto) throws Exception;
   boolean login(Member member) throws Exception;
   boolean validationId(String id) throws Exception;



}
