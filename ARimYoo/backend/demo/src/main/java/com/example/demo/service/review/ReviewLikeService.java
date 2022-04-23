package com.example.demo.service.review;

import com.example.demo.entity.review.Review;
import com.example.demo.entity.review.ReviewLike;
import com.example.demo.repository.review.ReviewLikeRepository;
import com.example.demo.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewLikeService {

    @Autowired
    private ReviewLikeRepository likeRepository;

    @Autowired
    private ReviewRepository boardRepository;

    public boolean addLike (String who, Long viewNo) {
        Review review = boardRepository.findById(viewNo).orElseThrow();

        // 중복 좋아요 방지
        if (likeRepository.findByWhoAndReview(who, review).isEmpty()) {
            likeRepository.save(new ReviewLike(who, review));
            return true;
        }
        return false;
    }
}
