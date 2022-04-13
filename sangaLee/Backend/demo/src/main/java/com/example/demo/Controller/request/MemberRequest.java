package com.example.demo.Controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String auth;

    public MemberRequest (String userId, String password, String auth) {
        this.id = userId;
        this.pw = password;
        this.auth = auth;
    }
}
