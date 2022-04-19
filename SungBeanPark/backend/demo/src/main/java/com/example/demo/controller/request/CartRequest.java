package com.example.demo.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class CartRequest {

    private Long memberNo;

    private Long cartId;
    private String imageUrl;
    private String productName;
    private Long discount;
    private Integer productPrice;
    private Integer productDiscountPrice;

    private Integer productNum;
    private String gender;
    private String rating;
    private Date regDate;

    public CartRequest(String imageUrl, String productName, Long discount, Integer productPrice, Integer productDiscountPrice, String gender, String rating) {
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.discount = discount;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.gender = gender;
        this.rating = rating;
    }
}
