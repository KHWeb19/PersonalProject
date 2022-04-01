package com.example.demo.controller.memberController.Response;

import lombok.Data;

@Data
public class MemberResponse {
    private String userId;
    private String auth;
    private String name;

    public MemberResponse(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public MemberResponse(String auth) {
        this.auth = auth;
    }
}
