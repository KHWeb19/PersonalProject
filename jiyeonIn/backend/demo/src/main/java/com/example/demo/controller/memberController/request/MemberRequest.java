package com.example.demo.controller.memberController.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String name;
    private String auth;


    public MemberRequest(String id, String pw, String name, String auth) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.auth = auth;
    }
}
