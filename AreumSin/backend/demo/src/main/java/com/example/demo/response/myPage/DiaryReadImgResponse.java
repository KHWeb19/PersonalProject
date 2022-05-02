package com.example.demo.response.myPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryReadImgResponse {

    private String diaryImgSrc;
    private Integer diaryImgNo;

    public DiaryReadImgResponse(String diaryImgSrc, Integer diaryImgNo) {
        this.diaryImgSrc = diaryImgSrc;
        this.diaryImgNo = diaryImgNo;
    }
}
