package com.example.demo.service.Member;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    public void register (MemberRequest memberRequest);

    public MemberRequest login (MemberRequest memberRequest);
    public Member read (Long memberNo);
    List<Member> findBusiness ();
  //  List<Member> findDong (String auth, String keyWord);
   public List<Member> searchList (String keyWord);
}
