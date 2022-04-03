package com.example.demo.controller.comments.freeBoardComments.request;

import lombok.Data;

@Data
public class FreeBoardCommentsRequest {
    private String writer;
    private String content;
    private Long boardNo;

    public FreeBoardCommentsRequest(String writer, String content, Long boardNo){
        this.writer = writer;
        this.content = content;
        this.boardNo = boardNo;

    }
}
