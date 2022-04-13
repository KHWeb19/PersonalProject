package com.example.demo.controller.FoodBoard.request;

import lombok.Data;

@Data
public class FoodBoardRequest {
    private String name;
    private String des;
    private String material;
    private String order;

    public FoodBoardRequest(String name, String des, String material, String order){
        this.name = name;
        this.des = des;
        this.material = material;
        this.order = order;
    }

}
