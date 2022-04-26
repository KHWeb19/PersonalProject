package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentRequest {

    private String Comment;
    private String writer;
    private Integer boardNo;

    public BoardCommentRequest(String comment, String writer, Integer boardNo) {
        Comment = comment;
        this.writer = writer;
        this.boardNo = boardNo;
    }
}
