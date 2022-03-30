package com.example.backend.controller.member.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MemberRequest {
    private String userId;
    private String password;
    private String passwordCheck;
    private String email;
    private String auth;

    public MemberRequest (String userId, String password, String passwordCheck,String email,String auth) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;
        this.auth = auth;
    }



}
