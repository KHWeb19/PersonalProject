package com.example.demo.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String name;
    private String auth;


    public MemberRequest(String userId, String password, String userName, String auth) {
        this.id = userId;
        this.pw = password;
        this.name = userName;
        this.auth = auth;
    }
}