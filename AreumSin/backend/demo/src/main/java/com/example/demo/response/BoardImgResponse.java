package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardImgResponse {

    private String imgSrc;
    private Integer boardImgNo;

    public BoardImgResponse(String imgSrc, Integer boardImgNo) {
        this.imgSrc = imgSrc;
        this.boardImgNo = boardImgNo;
    }
}
