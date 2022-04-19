package com.example.demo.controller.request;

import lombok.Data;

@Data
public class TipBoardRequest {
    private Long boardNo;
    private String title;
    private String writer;
    private String password;

    public TipBoardRequest (Long boarNo, String title, String writer, String password) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.password = password;
    }
}
