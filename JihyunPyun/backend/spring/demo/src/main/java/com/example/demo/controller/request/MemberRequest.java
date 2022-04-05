package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {
    private String id;
    private String pw;
    private String name;
    private String email;

    public MemberRequest(String id, String pw, String name, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }

    public MemberRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
