package com.example.demo.service.join;

import com.example.demo.entity.Member;
import com.example.demo.request.MemberRequest;

public interface JoinMemberService {
    void register(Member member);
    Boolean checkIdDuplicate(String id);
    MemberRequest login(MemberRequest memberRequest);

}
