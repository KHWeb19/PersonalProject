package com.example.demo.request;

import lombok.Data;

@Data
public class MemberRequest {
    // 요청 들어온것만 따로 처리하기 위해서
    private String id;
    private String pw;

    public MemberRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
