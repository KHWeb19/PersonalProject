package com.example.demo.controller.response;

import lombok.Data;

@Data
public class MemberResponse {
    private String sn;
    private String city;
    private String dong;
    private String address;

    public MemberResponse (String storeName, String city, String dong, String address) {
        this.sn = storeName;
        this.city = city;
        this.dong = dong;
        this.address = address;
    }
}
