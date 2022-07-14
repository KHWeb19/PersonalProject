package com.example.backend.controller.member.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SignInRequest {

    private String userId;
    private String password;

    public SignInRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
