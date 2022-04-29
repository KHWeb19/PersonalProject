package com.example.demo.response.map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapLikeMarkListResponse {

    private String x;
    private String y;
    private String title;

    public MapLikeMarkListResponse(String x, String y, String title) {
        this.x = x;
        this.y = y;
        this.title = title;
    }
}
