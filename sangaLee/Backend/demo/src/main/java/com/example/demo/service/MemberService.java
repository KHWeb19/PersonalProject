package com.example.demo.service;

import com.example.demo.Controller.request.MemberRequest;

public interface MemberService {
    public void register (MemberRequest memberRequest);

    public MemberRequest login (MemberRequest memberRequest);
}
