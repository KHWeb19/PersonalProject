package com.example.demo.controller.bookingController.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingReadRequest {
    private Long checkBookingNo;
    private String checkId;
}
