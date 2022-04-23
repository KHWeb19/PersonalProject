package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecisionMakingRequest {

    private String id;
    private Integer voteNo;

    public DecisionMakingRequest(String id, Integer voteNo) {
        this.id = id;
        this.voteNo = voteNo;
    }
}
