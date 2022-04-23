package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDayListRequest {

    private Integer planNo;
    private Integer day;

    public PlanDayListRequest(Integer planNo, Integer day) {
        this.planNo = planNo;
        this.day = day;
    }
}
