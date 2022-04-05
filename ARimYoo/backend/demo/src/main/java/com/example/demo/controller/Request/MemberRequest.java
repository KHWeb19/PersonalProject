package com.example.demo.controller.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {

    private Long memberNo;
    private String id;
    private String pw;
    private String name;
    private String birth;
    private String intro;
    private String profilePic;

    public MemberRequest(Long memberNo, String userId, String password
                        ) {
        this.memberNo = memberNo;
        this.id = userId;
        this.pw = password;


    }
}
