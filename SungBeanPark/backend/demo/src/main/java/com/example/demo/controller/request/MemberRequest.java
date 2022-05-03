package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Slf4j
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String pw;
    private String userName;
    private String auth;


    public MemberRequest(Long memberNo, String id, String pw, String userName) {
        this.memberNo = memberNo;
        this.id = id;
        this.pw = pw;
        this.userName = userName;
        this.auth = auth;
    }
}