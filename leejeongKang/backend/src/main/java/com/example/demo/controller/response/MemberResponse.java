package com.example.demo.controller.response;

import lombok.Data;

@Data
public class MemberResponse {
    private String id;
    private String password;
    private String name;
    private String birth;
    private String phone;

    public MemberResponse (String id, String password, String name, String birth, String phone) {

        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }
}
