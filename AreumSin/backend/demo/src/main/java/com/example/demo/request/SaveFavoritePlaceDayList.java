package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveFavoritePlaceDayList {

    private Integer planNo;
    private Integer day;

    public SaveFavoritePlaceDayList(Integer planNo, Integer day) {
        this.planNo = planNo;
        this.day = day;
    }
}
