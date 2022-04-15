package com.example.backend.controller;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/register/{boardNo}")
    public void commentRegister(@PathVariable("boardNo") Integer boardNo, @Validated @RequestBody CommentRequest commentRequest) {
        log.info("commentRegister()");


        commentRequest.setBoardNo(Long.valueOf(boardNo));
        service.register(boardNo, commentRequest);
    }

    @GetMapping("/list/{boardNo}")
    public List<Comment> commentList(@PathVariable("boardNo") Integer boardNo) {
        log.info("commentList()");

        return service.list(boardNo);
    }
    @DeleteMapping("/{commentNo}")
    public void commentRemove (@PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
