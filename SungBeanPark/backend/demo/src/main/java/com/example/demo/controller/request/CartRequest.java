package com.example.demo.controller.request;


import lombok.Data;


@Data
public class CartRequest {
    private Long cartId;
    private Long memberNo;

    private Long productId;
    private Long productNum;
    private Long productPrice;
    private Long productDiscountPrice;
    private String imageUrl;
    private String productName;
    private String gender;
    private String rating;

    public CartRequest( Long cartId, Long memberNo, Long productId, Long productNum, Long productPrice,  Long productDiscountPrice, String imageUrl, String productName,
                       String gender, String rating){
        this.cartId = cartId;
        this.memberNo = memberNo;
        this.productNum = productNum;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.gender = gender;
        this.rating = rating;
    }


}
