package com.example.demo.response.map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapLikeListResponse {
    private String title;
    private Integer favoritePlaceNo;

    public MapLikeListResponse(String title, Integer favoritePlaceNo) {
        this.title = title;
        this.favoritePlaceNo = favoritePlaceNo;
    }
}
