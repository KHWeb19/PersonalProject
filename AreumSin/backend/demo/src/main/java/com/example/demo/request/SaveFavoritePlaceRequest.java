package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveFavoritePlaceRequest {

    private Integer planNo;
    private String placeTitle;
    private String placeX;
    private String placeY;

    public SaveFavoritePlaceRequest(Integer planNo, String placeTitle, String placeX, String placeY) {
        this.planNo = planNo;
        this.placeTitle = placeTitle;
        this.placeX = placeX;
        this.placeY = placeY;
    }
}
