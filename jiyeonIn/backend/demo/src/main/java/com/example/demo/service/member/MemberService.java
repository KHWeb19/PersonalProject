package com.example.demo.service.member;

import com.example.demo.controller.memberController.Response.ManagerResponse;
import com.example.demo.controller.memberController.Response.MemberResponse;
import com.example.demo.controller.memberController.request.MemberRequest;

import java.util.List;

public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest) ;
    public Boolean checkUserIdValidation(String id);
    public MemberRequest read(String id);
    public void modify(MemberResponse member);
    public void remove(String id);
    public List<ManagerResponse> list();
}
