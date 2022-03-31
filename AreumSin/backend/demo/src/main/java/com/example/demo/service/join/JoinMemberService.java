package com.example.demo.service.join;

import com.example.demo.entity.Member;

public interface JoinMemberService {
    void register(Member member);

    Boolean checkIdDuplicate(String id);

}
