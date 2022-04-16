package com.example.demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Board {
    private String title;
    private String content;
    private String writer;
    private String fileName;
    private Long boardNo;
    private Date regDate;
    private int count;

    public Board(String title, String content, String writer, String fileName,
                 Long boardNo, Date regDate, int count) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.fileName = fileName;
        this.boardNo = boardNo;
        this.regDate = regDate;
        this.count = count;
    }
}
