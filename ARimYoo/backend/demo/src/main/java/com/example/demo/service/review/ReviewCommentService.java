package com.example.demo.service.review;

import com.example.demo.entity.review.ReviewComment;

import java.util.List;

public interface ReviewCommentService {

    public void register (Long reviewNo, ReviewComment reviewComment);
    public List<ReviewComment> list (Long reviewNo);
    public void delete (Long commentId);
}
