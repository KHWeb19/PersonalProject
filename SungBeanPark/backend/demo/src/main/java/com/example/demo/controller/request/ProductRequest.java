package com.example.demo.controller.request;

import lombok.Data;


@Data
public class ProductRequest {
    private String imageUrl;
    private String productName;
    private Long discount;
    private Integer productPrice;
    private Integer productDiscountPrice;
    private String gender;
    private String rating;
    public ProductRequest(String imageUrl, String productName, Long discount, Integer productPrice, Integer productDiscountPrice, String gender, String rating) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.discount = discount;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.gender = gender;
        this.rating = rating;
    }
}
