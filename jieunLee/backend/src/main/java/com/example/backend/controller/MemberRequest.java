package com.example.backend.controller;

import lombok.Data;

@Data
public class MemberRequest {
    private String memberName;
    private String memberId;
    private String password;

    public MemberRequest (String memberName, String memberId, String password) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
    }


}
