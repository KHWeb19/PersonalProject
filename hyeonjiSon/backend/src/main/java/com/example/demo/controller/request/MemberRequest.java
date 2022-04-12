package com.example.demo.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String sn;
    private String pw;
    private String pwConfirm;

    public MemberRequest (Long memberNo, String userId, String storeName, String password, String pwQAnswer) {
        this.memberNo = memberNo;
        this.id = userId;
        this.sn = storeName;
        this.pw = password;
        this.pwConfirm = pwQAnswer;
    }
}
