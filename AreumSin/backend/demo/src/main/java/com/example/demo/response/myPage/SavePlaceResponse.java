package com.example.demo.response.myPage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavePlaceResponse {

    private String placeName;
    private String planName;
    private String place;

    public SavePlaceResponse(String placeName, String planName, String place) {
        this.placeName = placeName;
        this.planName = planName;
        this.place = place;
    }
}
