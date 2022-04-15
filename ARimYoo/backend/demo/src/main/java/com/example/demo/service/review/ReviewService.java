package com.example.demo.service.review;

import com.example.demo.entity.review.Review;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewService {

    public void register (Review review, @RequestParam(required = false) MultipartFile file) throws Exception;
    public List<Review> list ();
    public Review read (Long reviewNo);
    public void modify (Review review, @RequestParam(required = false) MultipartFile file) throws Exception;
    public void remove (Integer reviewNo) throws Exception ;
    public List<Review> searchList (String keyword);
}
