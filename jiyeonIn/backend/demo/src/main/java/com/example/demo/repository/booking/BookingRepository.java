package com.example.demo.repository.booking;

import com.example.demo.entity.booking.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingInfo, Long> {

    @Query(value = "select * from booking_info where id = :checkId",nativeQuery = true)
    public List<BookingInfo> findIdList(String checkId);
}
