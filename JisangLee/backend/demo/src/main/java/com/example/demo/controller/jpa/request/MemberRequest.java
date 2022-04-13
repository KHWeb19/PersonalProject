package com.example.demo.controller.jpa.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String nickname;



    public MemberRequest(String userId, String password, String userNickname) {
        this.id = userId;
        this.pw = password;
        this.nickname = userNickname;

    }
}
