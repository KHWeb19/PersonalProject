package com.example.demo.request;

import lombok.Data;

@Data
public class QuestionBoardRequest {
    private String type;
    private String id;
    private String title;
    private String writer;
    private String content;

    public QuestionBoardRequest(String type, String id,String title, String writer, String content) {
        this.type= type;
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}