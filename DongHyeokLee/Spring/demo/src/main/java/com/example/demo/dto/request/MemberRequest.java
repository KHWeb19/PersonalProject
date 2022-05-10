package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberRequest {
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private String auth;

    public MemberRequest(String userId, String password, String nickname, String email, String auth){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.auth = auth;
    }
}
