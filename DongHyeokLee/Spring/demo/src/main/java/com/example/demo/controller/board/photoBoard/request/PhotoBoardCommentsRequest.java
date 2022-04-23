package com.example.demo.controller.board.photoBoard.request;

import lombok.Data;

@Data
public class PhotoBoardCommentsRequest {
    private String writer;
    private String content;
    private Long boardNo;

    public PhotoBoardCommentsRequest(String writer, String content, Long boardNo){
        this.writer = writer;
        this.content = content;
        this.boardNo = boardNo;

    }
}
