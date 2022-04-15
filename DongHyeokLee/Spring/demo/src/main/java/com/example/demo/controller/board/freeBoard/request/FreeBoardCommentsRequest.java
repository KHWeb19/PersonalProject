package com.example.demo.controller.board.freeBoard.request;

import lombok.Data;

import java.util.Date;

@Data
public class FreeBoardCommentsRequest {
    private String writer;
    private String comment;
    private Long boardNo;
    private Date regDate;


    public FreeBoardCommentsRequest() {
    }

    public FreeBoardCommentsRequest(String writer, String comment, Long boardNo, Date regDate){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
        this.regDate = regDate;


    }
}
