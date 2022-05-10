package com.example.demo.service.member;

import com.example.demo.dto.request.MemberRequest;
import com.example.demo.dto.response.DuplicationCheck;
import com.example.demo.entity.member.MemberInfo;

public interface MemberService {
    public DuplicationCheck register (MemberRequest memberRequest);
    public MemberRequest login (MemberRequest memberRequest);
    public void modify (MemberRequest memberRequest);
    public void remove (MemberInfo member);

}
