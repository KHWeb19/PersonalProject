package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.Member;

public interface MemberService {
    public void register (Member member);
    public Boolean login (MemberRequest memberRequest);
}
