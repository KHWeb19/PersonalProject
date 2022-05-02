package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveFavoritePlaceDay {

    private Integer favoritePlaceNo;
    private Integer day;

    public SaveFavoritePlaceDay(Integer favoritePlaceNo, Integer day) {
        this.favoritePlaceNo = favoritePlaceNo;
        this.day = day;
    }
}
