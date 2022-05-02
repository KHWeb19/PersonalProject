package com.example.demo.response.myPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryReadResponse {

    private String title;
    private String planName;
    private String content;

    public DiaryReadResponse(String title, String planName, String content) {
        this.title = title;
        this.planName = planName;
        this.content = content;
    }
}
