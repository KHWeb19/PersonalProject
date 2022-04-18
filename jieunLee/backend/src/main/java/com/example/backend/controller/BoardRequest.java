package com.example.backend.controller;

import com.example.backend.entity.Member;
import lombok.Data;

@Data
public class BoardRequest {
    private Long boardNo;
    private String boardImage;
    private String writer;
    private String content;
    private Long memberNo;
    private Member member;

    public BoardRequest (Long boardNo, String boardImage, String writer, String content, Long memberNo, Member member) {
        this.boardNo = boardNo;
        this.boardImage = boardImage;
        this.writer = writer;
        this.content = content;
        this.memberNo = memberNo;
        this.member = member;
    }
}
