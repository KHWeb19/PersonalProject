package com.example.demo.service.review;

import com.example.demo.controller.reviewController.request.ReviewRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.repository.review.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository repository;

    @Transactional
    @Override
    public void includeImgReview(ReviewRequest info, String originalFilename) {
        String file = info.getId() +"."+ originalFilename;

        Review review = new Review(info.getId(), info.getContent(), file);
        repository.save(review);
    }

    @Override
    public void exceptImgReview(ReviewRequest info) {
        Review review = new Review(info.getId(), info.getContent());
        repository.save(review);
    }

    @Override
    public List<Review> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"reviewNo"));
    }

}
