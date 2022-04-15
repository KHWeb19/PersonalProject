package com.example.demo.controller;

import com.example.demo.service.communityBoard.CommunityBoardLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityBoardLikeController {

    @Autowired
    private CommunityBoardLikeService likeService;

    @PostMapping("/{boardNo}/like")
    public boolean addLike (@RequestBody String who, @PathVariable("boardNo") Long boardNo ) {
        log.info ("like board !" + who + boardNo);
        return likeService.addLike(who, boardNo);
    }
}
