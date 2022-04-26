package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentResponse {

    private String Comment;
    private String writer;
    private Integer boardCommentNo;

    public BoardCommentResponse(String comment, String writer, Integer boardCommentNo) {
        Comment = comment;
        this.writer = writer;
        this.boardCommentNo = boardCommentNo;
    }
}
