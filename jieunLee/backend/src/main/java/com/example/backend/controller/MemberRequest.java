package com.example.backend.controller;

import lombok.Data;

import java.util.Date;

@Data
public class MemberRequest {
    private Long memberNo;
    private String memberName;
    private String memberId;
    private String password;
    private String memberWeb;
    private String memberIntro;
    private Date regData;

    public MemberRequest (Long memberNo, String memberName, String memberId, String password, String memberWeb, String memberIntro, Date regData) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
        this.memberWeb = memberWeb;
        this.memberIntro = memberIntro;
        this.regData = regData;
    }


}
