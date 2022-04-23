package com.example.demo.controller.memberController.Response;

import lombok.Data;

import java.util.Date;

@Data
public class ManagerResponse {
    private String id;
    private String name;
    private Long bookingCount;
    private Long reviewCount;
    private Date regDate;

//    public ManagerResponse(String id, String name, Long bookingCount, Long reviewCount, Date regDate){
//        this.id = id;
//        this.name = name;
//        this.bookingCount = bookingCount;
//    }
}
