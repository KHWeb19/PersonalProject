package com.example.demo.Controller.request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    private String writer;
    private String content;

    public BoardRequest(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
