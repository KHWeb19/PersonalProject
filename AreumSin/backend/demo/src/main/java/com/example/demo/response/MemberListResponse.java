package com.example.demo.response;

import lombok.Data;

@Data
public class MemberListResponse {
    private String memberId;
    private String memberName;
    private String memberColor;

    public MemberListResponse(String memberId, String memberName, String memberColor) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberColor = memberColor;
    }
}
