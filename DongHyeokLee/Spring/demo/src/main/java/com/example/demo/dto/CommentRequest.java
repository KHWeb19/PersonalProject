package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class CommentRequest {
    private String writer;
    private String comment;
    private Long boardNo;
    private Date regDate;


    public CommentRequest(String writer, String comment, Long boardNo, Date regDate) {
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
        this.regDate = regDate;

    }
}