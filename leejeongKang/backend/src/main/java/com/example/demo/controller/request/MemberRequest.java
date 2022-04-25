package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String password;
    private String name;
    private String birth;
    private String phone;
    private String auth;

    //회원가입용
    public MemberRequest (String id, String password, String name, String birth, String phone, String auth){
        this.id=id;
        this.password=password;
        this.name=name;
        this.birth=birth;
        this.phone=phone;
        this.auth=auth;
    }

    //checkID
    public MemberRequest (String id){
        this.id = id;
    }

    //로그인
    public MemberRequest (Long memberNo, String id, String password, String name, String birth, String phone){
        this.memberNo = memberNo;
        this.id=id;
        this.password=password;
        this.name=name;
        this.birth=birth;
        this.phone=phone;
    }
}