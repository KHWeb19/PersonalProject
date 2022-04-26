package com.example.demo.controller.request;

import lombok.Data;


@Data
public class ProductRequest {

    private Long productId;
    private String imageUrl;
    private String productName;
    private Integer discount;
    private Integer productPrice;
    private Integer productDiscountPrice;
    private String gender;
    private String rating;
    private String fileName;
    public ProductRequest(Long productId, String imageUrl, String productName, Integer discount, Integer productPrice, Integer productDiscountPrice, String gender, String rating, String fileName) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.discount = discount;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.gender = gender;
        this.rating = rating;
        this.fileName = fileName;
    }
}
