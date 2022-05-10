package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class LikeRequest {
    private Long boardNo;
    private String writer;
    private Date regDate;
    private Long likeNo;
    private int likeCheck;

    public LikeRequest (Long boardNo, String writer, Date regDate, Long likeNo, int likeCheck){
        this.boardNo = boardNo;
        this.writer = writer;
        this.regDate = regDate;
        this.likeNo = likeNo;
        this.likeCheck = likeCheck;
    }
}
