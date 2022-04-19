package com.example.backend.service.jpa;

import com.example.backend.controller.member.request.MemberRequest;

public interface JpaMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception;

}
