package com.example.demo.controller;

import com.example.demo.service.TipBoard.TipBoardLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tipboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TipBoardLikeController {

    @Autowired
    private TipBoardLikeService likeService;

    @PostMapping("/{boardNo}/like")
    public boolean addLike (@RequestBody String who, @PathVariable("boardNo") Long boardNo) {
        log.info ("like click" + who + boardNo );
        return likeService.addLike(who, boardNo);
    }
}
