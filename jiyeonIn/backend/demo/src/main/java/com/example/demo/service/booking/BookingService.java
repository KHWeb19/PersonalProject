package com.example.demo.service.booking;

import com.example.demo.controller.bookingController.request.BookingRequest;

public interface BookingService {
    public void register(BookingRequest info, String originalFilename);

    public void exceptFilesBooking(BookingRequest info);
}
