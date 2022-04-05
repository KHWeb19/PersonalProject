package com.example.demo.request;

import lombok.Data;

@Data
public class MemberRequest {
    // 요청 들어온것만 따로 처리하기 위해서
    private String id;
    private String pw;
    private String name;
    private Integer birth;
    private Boolean checkId;
    private String sessionKey;

    public MemberRequest(String id, String pw, String name, Integer birth, Boolean checkId, String sessionKey) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
        this.checkId = checkId;
        this.sessionKey = sessionKey;
    }
}
