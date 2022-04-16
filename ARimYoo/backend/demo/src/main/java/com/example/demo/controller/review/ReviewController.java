package com.example.demo.controller.review;

import com.example.demo.controller.Request.keywordRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.service.review.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/review")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping("/register")
    public void ReviewRegister (@Validated Review review, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("ReviewRegister();" + file);
        service.register(review, file);

    }

    @GetMapping("/list")
    public List<Review> reviewList () {
        log.info("ReviewList");

        return service.list ();
    }

    @GetMapping("/{reviewNo}")
    public Review read (
            @PathVariable("reviewNo") Long reviewNo) {
        log.info("read()");
        return service.read(reviewNo);
    }

    @PutMapping("/{reviewNo}")
    public Review modify (
            @PathVariable("reviewNo") Integer reviewNo,
            Review review, @RequestParam(required = false) MultipartFile file) throws Exception  {
        log.info("modify(): " + review);

        review.setReviewNo(Long.valueOf(reviewNo));
        service.modify(review, file);

        return review;
    }

    @DeleteMapping("/{reviewNo}")
    public void remove(
            @PathVariable("reviewNo") Integer reviewNo, Review review) throws Exception  {
        log.info("remove()");
        service.remove(reviewNo);

    }

    @PostMapping("/search")
    public List<Review> searchList (@RequestBody keywordRequest keyword) {
        log.info("searchList! " + keyword);
        String key = keyword.getKeyword();
        return service.searchList(key);
    }

}
