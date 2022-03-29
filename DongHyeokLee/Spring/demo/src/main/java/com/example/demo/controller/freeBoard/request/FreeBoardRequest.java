package com.example.demo.controller.freeBoard.request;

import lombok.Data;

@Data
public class FreeBoardRequest {
    private String title;
    private String writer;
    private String content;

    public FreeBoardRequest(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
