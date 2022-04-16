package com.example.backend.controller;

import lombok.Data;

@Data
public class BoardRequest {
    private String boardImage;
    private String writer;
    private String content;
    private Long memberNo;

    public BoardRequest (String boardImage, String writer, String content, Long memberNo) {
        this.boardImage = boardImage;
        this.writer = writer;
        this.content = content;
        this.memberNo = memberNo;
    }
}
