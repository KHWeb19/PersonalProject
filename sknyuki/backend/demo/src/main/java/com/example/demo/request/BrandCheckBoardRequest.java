package com.example.demo.request;

import lombok.Data;

@Data
public class BrandCheckBoardRequest {
    private String title;
    private String writer;
    private String content;

    public BrandCheckBoardRequest(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
