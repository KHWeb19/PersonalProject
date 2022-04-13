package com.example.demo.service.review;

import com.example.demo.controller.reviewController.request.ReviewRequest;
import com.example.demo.entity.review.Review;

import java.util.List;

public interface ReviewService {
    public void includeImgReview(ReviewRequest info, String originalFilename);

    public void exceptImgReview(ReviewRequest info);

    public List<Review> list();
}
