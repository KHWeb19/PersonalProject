package com.example.demo.controller.request;

import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    private String id;
    private String content;

    public BoardRequest (String title, String id, String content) {
        this.title = title;
        this.id = id;
        this.content = content;
    }
}
