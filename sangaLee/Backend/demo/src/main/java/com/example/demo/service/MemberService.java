package com.example.demo.service;

import com.example.demo.Controller.request.MemberRequest;
import com.example.demo.entity.Member;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberService {
    public void register(Member member);
    public MemberRequest login (MemberRequest memberRequest);
    public void modify (Member member);
}
