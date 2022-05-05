package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardReplyRequest {

    private String reply;
    private String writer;
    private Integer commentNo;

    public BoardReplyRequest(String reply, String writer, Integer commentNo) {
        this.reply = reply;
        this.writer = writer;
        this.commentNo = commentNo;
    }
}
