package com.example.backend.controller;

import lombok.Data;

@Data
public class CommentRequest {

    private String writer;
    private String content;
    private Long boardNo;

    public CommentRequest(String writer, String content, Long boardNo){
        this.writer = writer;
        this.content = content;
        this.boardNo = boardNo;
    }
}
