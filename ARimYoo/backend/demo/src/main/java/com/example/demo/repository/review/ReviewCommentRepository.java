package com.example.demo.repository.review;

import com.example.demo.entity.review.Review;
import com.example.demo.entity.review.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {
    List<ReviewComment> findReviewCommentByReview(Review review);
}
