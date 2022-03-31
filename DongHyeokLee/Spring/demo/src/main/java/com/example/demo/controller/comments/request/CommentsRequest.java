package com.example.demo.controller.comments.request;

import lombok.Data;

@Data
public class CommentsRequest {
    private String writer;
    private String content;
    private Long boardNo;

    public CommentsRequest(String writer, String content, Long boardNo){
        this.writer = writer;
        this.content = content;
        this.boardNo = boardNo;

    }
}
