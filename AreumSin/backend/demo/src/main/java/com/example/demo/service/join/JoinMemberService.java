package com.example.demo.service.join;

import com.example.demo.entity.Member;
import com.example.demo.request.MemberRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface JoinMemberService {
    void register(Member member, HttpSession session);
    Boolean checkIdDuplicate(String id);
    MemberRequest login(MemberRequest memberRequest);
    Integer memberNo(String id);
    List<Member> list() throws Exception;
}
