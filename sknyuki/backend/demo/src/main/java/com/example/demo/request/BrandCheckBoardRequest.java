package com.example.demo.request;

import lombok.Data;

@Data
public class BrandCheckBoardRequest {
    private String id;
    private String title;
    private String writer;
    private String content;

    public BrandCheckBoardRequest(String id,String title, String writer, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
