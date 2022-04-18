package com.example.demo.service.member;

import com.example.demo.controller.memberController.request.MemberRequest;

public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest) ;
    public Boolean checkUserIdValidation(String id);
    public MemberRequest read(String id);
}
