package com.example.demo.request;

import lombok.Data;

@Data
public class PlanFriend {
    private String friendId;
    private Integer planNo;

    public PlanFriend(String friendId, Integer planNo) {
        this.friendId = friendId;
        this.planNo = planNo;
    }
}
