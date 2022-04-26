package com.example.backend.controller;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;
import com.example.backend.service.LikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/likes")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/{boardNo}/{memberNo}")
    public boolean likes(@PathVariable("boardNo") Long boardNo, @PathVariable("memberNo") Long memberNo, @Validated @RequestBody Likes likes) {
        log.info("likes()");
        return likesService.register(boardNo, memberNo, likes);
    }

    @GetMapping("/list/{boardNo}/{memberNo}")
    public List<Likes> likesList(@PathVariable("boardNo") Long boardNo, @PathVariable("memberNo") Long memberNo) {
        log.info("likesList()");

        return likesService.list(boardNo, memberNo);
    }

    @GetMapping("/list/{boardNo}")
    public List<Likes> likesList(@PathVariable("boardNo") Long boardNo) {
        log.info("likesList()");

        return likesService.list(boardNo);
    }

//    @DeleteMapping("/{likesNo}")
//    public void unLikes(@PathVariable("likesNo") Integer likesNo) {
//        log.info("unLikes()");
//        likesService.remove(likesNo);
//    }
}
