package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardImgRequest {

    private Integer boardImgNo;

    public BoardImgRequest(Integer boardImgNo) {
        this.boardImgNo = boardImgNo;
    }
}
