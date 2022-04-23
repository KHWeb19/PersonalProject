package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteResponse {

    private Integer voteNo;
    private String voteContent;
    private Integer agreement;
    private Integer opposition;

    public VoteResponse(Integer voteNo, String voteContent, Integer agreement, Integer opposition) {
        this.voteNo = voteNo;
        this.voteContent = voteContent;
        this.agreement = agreement;
        this.opposition = opposition;
    }
}
