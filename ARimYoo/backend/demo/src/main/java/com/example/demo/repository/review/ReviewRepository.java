package com.example.demo.repository.review;

import com.example.demo.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTitleContaining(String keyword);
    List<Review> findTop5ByOrderByLikeCntDesc();
}
