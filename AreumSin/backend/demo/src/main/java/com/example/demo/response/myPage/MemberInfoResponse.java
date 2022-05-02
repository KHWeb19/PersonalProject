package com.example.demo.response.myPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoResponse {

    private Integer memberNo;
    private String id;
    private String name;
    private Integer birth;
    private String color;

    public MemberInfoResponse(Integer memberNo, String id, String name, Integer birth, String color) {
        this.memberNo = memberNo;
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.color = color;
    }
}
