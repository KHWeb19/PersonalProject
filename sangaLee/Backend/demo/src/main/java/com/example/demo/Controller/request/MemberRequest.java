package com.example.demo.Controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String password;

    public MemberRequest (String userId, String password) {
        this.id = userId;
        this.password = password;
    }
}
