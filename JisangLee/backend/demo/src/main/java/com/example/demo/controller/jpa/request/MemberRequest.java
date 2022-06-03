package com.example.demo.controller.jpa.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect
@Data
public class MemberRequest{
    private String id;
    private String pw;
    private String nickname;
    private String auth;
    private Long member_No;

    public MemberRequest(){

    }

    public MemberRequest(String userId, String password, String userNickname, String auth) {
        this.id = userId;
        this.pw = password;
        this.nickname = userNickname;
        this.auth = auth;
    }

    public MemberRequest(String nickname, String auth) {
    }

}
