package com.example.demo.controller.board.freeBoard.request;

import lombok.Data;

@Data
public class FreeBoardCommentsRequest {
    private String writer;
    private String comment;
    private Long boardNo;

    public FreeBoardCommentsRequest() {
    }

    public FreeBoardCommentsRequest(String writer, String comment, Long boardNo){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;

    }
}
