package com.example.demo.response;

import lombok.Data;

@Data
public class PlanResponse {
    private Integer planNo;
    private String planName;
    private String planDate;
    private String placeName;
    private String planImgSrc;

    public PlanResponse(Integer planNo, String planName, String planDate, String placeName, String planImgSrc) {
        this.planNo = planNo;
        this.planName = planName;
        this.planDate = planDate;
        this.placeName = placeName;
        this.planImgSrc = planImgSrc;
    }

}
