package com.example.demo.response.myPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryListResponse {

    private String title;
    private String planName;
    private Integer diaryNo;
    private String diarySrc;

    public DiaryListResponse(String title, String planName, Integer diaryNo, String diarySrc) {
        this.title = title;
        this.planName = planName;
        this.diaryNo = diaryNo;
        this.diarySrc = diarySrc;
    }
}
