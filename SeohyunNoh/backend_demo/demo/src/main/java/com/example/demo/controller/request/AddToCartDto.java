package com.example.demo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDto {

    private Integer id;

    private Integer productId;

    private String memberId; // 멤버 체크 0426

    private Integer quantity;

}
