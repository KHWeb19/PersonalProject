package com.example.backend.controller.board.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommentRequest {

    private Long boardNo;
    private String commentWriter;
    private String comment;
    private Date regDate;

    public CommentRequest( Long boardNo,String commentWriter, String comment, Date regDate) {
        this.boardNo = boardNo;
        this.commentWriter = commentWriter;
        this.comment = comment;
        this.regDate = regDate;

    }
}
