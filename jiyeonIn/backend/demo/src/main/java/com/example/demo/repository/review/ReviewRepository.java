package com.example.demo.repository.review;

import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from review where review_no = :reviewNo",nativeQuery = true)
    Optional<Review> findInfo(Long reviewNo);

    @Query(value = "select * from review where id = :checkId",nativeQuery = true)
    public List<Review> findIdList(String checkId);


}
