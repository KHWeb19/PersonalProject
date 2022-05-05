package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryModifyRequest {

    private String title;
    private String planName;
    private String content;

    public DiaryModifyRequest(String title, String planName, String content) {
        this.title = title;
        this.planName = planName;
        this.content = content;
    }
}
