package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCommentResponse {

    private String Comment;
    private String writer;
    private Integer boardCommentNo;
    private Integer deep;
    private Integer parent;

    public BoardCommentResponse(String comment, String writer, Integer boardCommentNo, Integer deep, Integer parent) {
        Comment = comment;
        this.writer = writer;
        this.boardCommentNo = boardCommentNo;
        this.deep = deep;
        this.parent = parent;
    }
}
