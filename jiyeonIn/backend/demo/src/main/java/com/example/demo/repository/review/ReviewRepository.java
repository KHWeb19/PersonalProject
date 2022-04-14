package com.example.demo.repository.review;

import com.example.demo.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from review where review_no = :reviewNo",nativeQuery = true)
    Optional<Review> findInfo(Long reviewNo);
}
