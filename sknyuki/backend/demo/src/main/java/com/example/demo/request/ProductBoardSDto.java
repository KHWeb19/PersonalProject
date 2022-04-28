package com.example.demo.request;

import lombok.Data;

@Data
public class ProductBoardSDto {
    private String type;
    private String id;
    private String name;
    private String size;
    private int price;
    private String brandrank;
    private String accessories;
    private String status;
    private boolean soldCheck;


    public ProductBoardSDto(String type, String id, String name, String size, int price, String brandrank, String accessories, String status, boolean soldCheck) {
        this.type= type;
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brandrank = brandrank;
        this.accessories = accessories;
        this.status = status;
        this.soldCheck = soldCheck;
    }
}
