package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoteRequest {

    private String voteContent;
    private Integer planNo;

    public VoteRequest(String vote, Integer planNo) {
        this.voteContent = vote;
        this.planNo = planNo;
    }
}
