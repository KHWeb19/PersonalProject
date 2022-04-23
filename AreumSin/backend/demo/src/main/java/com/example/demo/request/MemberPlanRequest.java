package com.example.demo.request;

import lombok.Data;

@Data
public class MemberPlanRequest {
    private String id;
    private String planName;
    private String planDate;
    private String placeName;

    public MemberPlanRequest(String id, String planName, String planDate, String placeName) {
        this.id = id;
        this.planName = planName;
        this.planDate = planDate;
        this.placeName = placeName;
    }
}
