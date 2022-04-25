package com.example.demo.controller.Member.response;

import lombok.Data;

@Data
public class MemberResponse {
    private String id;

    public MemberResponse(String id){
        this.id = id;
    }
}
