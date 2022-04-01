package com.example.backend.controller;

import lombok.Data;

@Data
public class MemberRequest {
    private String name;
    private String id;
    private String pw;
    private String auth;

    public MemberRequest (String name, String id, String pw, String auth) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.auth = auth;
    }


}
