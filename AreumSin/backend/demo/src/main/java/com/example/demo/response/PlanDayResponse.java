package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanDayResponse {

    private String id;
    private String content;

    public PlanDayResponse(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
