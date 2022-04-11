package com.example.demo.controller.board.videoBoard.request;

import lombok.Data;

@Data
public class VideoBoardCommentsRequest {
    private String writer;
    private String content;
    private Long boardNo;

    public VideoBoardCommentsRequest(String writer, String content, Long boardNo){
        this.writer = writer;
        this.content = content;
        this.boardNo = boardNo;

    }
}
