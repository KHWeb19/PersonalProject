package com.example.demo.controller.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {

    private String id;
    private String pw;

    public MemberRequest(String userId, String password) {
        this.id = userId;
        this.pw = password;

    }
}
