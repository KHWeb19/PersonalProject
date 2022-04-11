package com.example.backend.controller;

import lombok.Data;

@Data
public class BoardRequest {
    private String boarImage;
    private String writer;
    private String content;

    public BoardRequest (String boarImage, String writer, String content) {
        this.boarImage = boarImage;
        this.writer = writer;
        this.content = content;
    }
}
