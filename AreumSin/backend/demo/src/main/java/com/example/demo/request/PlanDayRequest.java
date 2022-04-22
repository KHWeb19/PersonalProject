package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDayRequest {

    private String id;
    private Integer planNo;
    private Integer day;
    private String content;

    public PlanDayRequest(String id, Integer planNo, Integer day, String content) {
        this.id = id;
        this.planNo = planNo;
        this.day = day;
        this.content = content;
    }
}
