package com.example.demo.service;

import com.example.demo.Controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberService {
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest) ;
}