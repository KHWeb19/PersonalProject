package com.example.backend.controller;

import lombok.Data;

@Data
public class MemberRequest {
    private String name;
    private String id;
    private String pw;

    public MemberRequest (String name, String id, String pw) {
        this.name = name;
        this.id = id;
        this.pw = pw;
    }


}
