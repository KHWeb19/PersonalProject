package com.example.demo.controller.Member.response;

import lombok.Data;

@Data
public class MemberResponse {
    private Long memberNo;
    private String auth;
    private String id;
    private String nickName;


    public MemberResponse(Long memberNo, String id,String nickName){
        this.memberNo = memberNo;
        this.id = id;
        this.nickName = nickName;

    }


}
