package com.example.demo.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String id;
    private String pw;
    private String name;
    private Integer birth;
    private Boolean checkId;

    public MemberRequest(String id, String pw, String name, Integer birth, Boolean checkId) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
        this.checkId = checkId;
    }
}
