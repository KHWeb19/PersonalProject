package com.example.demo.request;

import lombok.Data;

@Data
public class ProductBoardSDto {
    private String type;
    private String id;
    private String name;
    private String size;
    private int price;
    private String rank;
    private String accessories;
    private String status;



    public ProductBoardSDto(String type, String id, String name, String rank, String accessories, String status, int price, String size ) {
        this.type= type;
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.rank = rank;
        this.accessories = accessories;
        this.status = status;
    }
}
