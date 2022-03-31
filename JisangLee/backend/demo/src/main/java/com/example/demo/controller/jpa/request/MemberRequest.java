package com.example.demo.controller.jpa.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String pwc;
    private String nickname;
    private String email;
    private Integer phonenumber;


    public MemberRequest(String userId, String password, String pwc, String userNickname, String userEmail, Integer userPhonenumber ) {
        this.id = userId;
        this.pw = password;
        this.pwc = pwc;
        this.nickname = userNickname;
        this.email = userEmail;
        this.phonenumber = userPhonenumber;
    }
}
