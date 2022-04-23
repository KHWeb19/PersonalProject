package com.example.demo.response;

import lombok.Data;

@Data
public class FriendMemberResponse {
    private String memberId;
    private String memberName;

    public FriendMemberResponse(String friendId, String memberName) {
        this.memberId = friendId;
        this.memberName = memberName;
    }
}
