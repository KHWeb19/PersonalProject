package com.example.backend.controller;

import com.example.backend.entity.Likes;
import com.example.backend.service.LikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/likes")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/{boardNo}/{memberNo}")
    public void likes(@PathVariable("boardNo") Integer boardNo, @PathVariable("memberNo") Integer memberNo, @Validated @RequestBody Likes likes) {
        log.info("likes()");
        likesService.register(boardNo, memberNo, likes);
    }

    @DeleteMapping("/{boardNo}")
    public void unLikes(@PathVariable("boardNo") Integer likesNo) {
        log.info("unLikes()");
        likesService.remove(likesNo);
    }
}
