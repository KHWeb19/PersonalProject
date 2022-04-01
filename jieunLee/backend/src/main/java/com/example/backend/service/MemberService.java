package com.example.backend.service;

import com.example.backend.controller.MemberRequest;

public interface MemberService {
    public void register (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
}
