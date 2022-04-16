package com.example.demo.controller.review;

import com.example.demo.service.communityBoard.CommunityBoardLikeService;
import com.example.demo.service.review.ReviewLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/board/review")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReviewLikeController {

    @Autowired
    private ReviewLikeService likeService;

    @PostMapping("/{reviewNo}/like")
    public boolean addLike (@RequestBody String who, @PathVariable("reviewNo") Long reviewNo ) {
        log.info ("like board !" + who + reviewNo);
        return likeService.addLike(who, reviewNo);
    }
}
