package com.example.demo.controller.bookingController.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String id;
    private String date;
    private String time;
    private String contents;
    private Long cakeArrNo;

}
