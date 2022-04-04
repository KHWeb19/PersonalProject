package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.VueJpaMember;

public interface VueJpaMemberService {
    public void register(VueJpaMember member);

    public MemberRequest login (MemberRequest memberRequest);

    public Boolean checkUserIdValidation(String id);

    public Boolean checkUserNicknameValidation(String nickname);
}
