package com.example.demo.controller.user.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String auth;

    public MemberRequest(String userId, String password) {
        this.id = userId;
        this.pw = password;
        this.auth = auth;
    }

}
