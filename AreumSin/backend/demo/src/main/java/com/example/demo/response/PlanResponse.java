package com.example.demo.response;

import lombok.Data;

@Data
public class PlanResponse {
    private String planName;
    private String planDate;
    private String placeName;

    public PlanResponse(String planName, String planDate, String placeName) {
        this.planName = planName;
        this.planDate = planDate;
        this.placeName = placeName;
    }

}
