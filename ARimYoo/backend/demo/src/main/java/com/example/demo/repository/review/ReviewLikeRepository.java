package com.example.demo.repository.review;

import com.example.demo.entity.review.Review;
import com.example.demo.entity.review.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {
    Optional<ReviewLike> findByWhoAndReview (String who, Review review);
}
