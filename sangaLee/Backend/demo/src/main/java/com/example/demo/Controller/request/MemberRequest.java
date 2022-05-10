package com.example.demo.Controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {
    private Long memberNo;
    private String id;
    private String pw;
    private String email;

    public MemberRequest(Long memberNo, String userId, String password, String userEmail) {
        this.memberNo = memberNo;
        this.id = userId;
        this.pw = password;
        this.email = userEmail;
    }
}
