package com.example.demo.controller.Member.request;

import lombok.Data;

@Data
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String pw;
    private String name;
    private String nickName;
    private String email;
    private String auth;


    public MemberRequest (Long memberNo, String id, String pw, String name, String nickName, String email, String auth) {
        this.memberNo = memberNo;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.auth = auth;
    }
}
