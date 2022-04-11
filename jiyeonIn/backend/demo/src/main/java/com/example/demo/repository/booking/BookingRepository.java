package com.example.demo.repository.booking;

import com.example.demo.entity.booking.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingInfo, Long> {
}
