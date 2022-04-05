package com.example.backend.controller;

import lombok.Data;

@Data
public class MemberResponse {
    private String memberId;
    public MemberResponse(String memberId) {
        this.memberId = memberId;
    }
}
