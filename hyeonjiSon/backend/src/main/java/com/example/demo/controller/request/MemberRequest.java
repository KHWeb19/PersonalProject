package com.example.demo.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String sn;
    private String pw;
    private String pwConfirm;

    public MemberRequest (String userId, String storeName, String password, String pwQAnswer) {
        this.id = userId;
        this.sn = storeName;
        this.pw = password;
        this.pwConfirm = pwQAnswer;
    }
}
