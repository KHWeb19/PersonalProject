package com.example.backend.controller;

import com.example.backend.service.LikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/likes")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/{boardNo}/{memberNo}")
    public boolean likes(@PathVariable("boardNo") Long boardNo, @PathVariable("memberNo") Long memberNo) {
        log.info("likes()");
        return likesService.register(boardNo, memberNo);
    }

//    @DeleteMapping("/{likesNo}")
//    public void unLikes(@PathVariable("likesNo") Integer likesNo) {
//        log.info("unLikes()");
//        likesService.remove(likesNo);
//    }
}
