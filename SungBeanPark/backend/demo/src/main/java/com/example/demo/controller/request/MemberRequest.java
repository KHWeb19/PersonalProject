package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private Long memberNo;
    private String userId;
    private String pw;
    private String name;
    private String auth;


    public MemberRequest(Long memberNo, String userId, String password, String userName) {
        this.memberNo =  memberNo;
        this.userId = userId;
        this.pw = password;
        this.name = userName;
        this.auth = auth;
    }
}