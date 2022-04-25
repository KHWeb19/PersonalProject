package com.example.demo.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String sn;
    private String pw;

    private String city;
    private String dong;
    private String address;

    private String pwConfirm;
    private String auth;

    public MemberRequest (Long memberNo, String userId, String storeName, String password,
                          String city, String dong, String address,
                          String pwQAnswer, String auth) {
        this.memberNo = memberNo;
        this.id = userId;
        this.sn = storeName;
        this.pw = password;

        this.city = city;
        this.dong = dong;
        this.address = address;

        this.pwConfirm = pwQAnswer;
        this.auth = auth;
    }

    public MemberRequest (Long memberNo){}

}
