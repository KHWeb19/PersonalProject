package com.example.demo.controller.review;

import com.example.demo.entity.review.ReviewComment;
import com.example.demo.service.review.ReviewCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/review")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReviewCommentController {

    @Autowired
    private ReviewCommentService service;

    @PostMapping("/{reviewNo}/comment/register")
    public void register (@Validated ReviewComment reviewComment, @PathVariable ("reviewNo") Long reviewNo
                          ){
        log.info("register" + reviewComment);
        service.register(reviewNo, reviewComment);

    }

    @GetMapping("/{reviewNo}/comment/list")
    public List<ReviewComment> read (@PathVariable("reviewNo") Long reviewNo){
        log.info("comment List");
        return service.list(reviewNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , ReviewComment reviewComment) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
