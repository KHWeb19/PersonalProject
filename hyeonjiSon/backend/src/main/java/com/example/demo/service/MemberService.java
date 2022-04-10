package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;

public interface MemberService {
    public void register (MemberRequest memberRequest);

    public MemberRequest login (MemberRequest memberRequest);
}
