package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoModifyRequest {

    private String id;
    private String name;
    private String pw;
    private Integer birth;
    private String color;

    public MemberInfoModifyRequest(String id, String name, String pw, Integer birth, String color) {
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.birth = birth;
        this.color = color;
    }
}
