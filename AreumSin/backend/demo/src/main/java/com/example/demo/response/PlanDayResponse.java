package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanDayResponse {

    private String id;
    private Integer planDayNo;
    private String content;
    private Integer likeCount;
    private Integer hateCount;
    private String imgSrc;

    public PlanDayResponse(String id, Integer planDayNo, String content, Integer likeCount, Integer hateCount, String imgSrc) {
        this.id = id;
        this.planDayNo = planDayNo;
        this.content = content;
        this.likeCount = likeCount;
        this.hateCount = hateCount;
        this.imgSrc = imgSrc;
    }
}
