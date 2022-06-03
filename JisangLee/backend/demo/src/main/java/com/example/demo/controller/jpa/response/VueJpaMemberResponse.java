package com.example.demo.controller.jpa.response;

import lombok.Data;

@Data
public class VueJpaMemberResponse {
    private String userId;

    public VueJpaMemberResponse(String userId) {
        this.userId = userId;
    }
}
