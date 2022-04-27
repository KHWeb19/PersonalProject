package com.example.demo.controller.board.request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;

    private String content;

    public BoardRequest(String title, String content) {
        this.title = title;

        this.content = content;
    }
}
