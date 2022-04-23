package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountRequest {

    private String id;
    private Integer planDayNo;

    public CountRequest(String id, Integer planDayNo) {
        this.id = id;
        this.planDayNo = planDayNo;
    }
}
