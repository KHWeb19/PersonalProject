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

    @PostMapping("/register")
    public void commentRegister(@Validated @RequestBody Comment comment) {
        log.info("commentRegister()");

        service.register(comment);
    }

    @GetMapping("/list/{boardNo}")
    public List<Comment> boardNoCommentList(@PathVariable("boardNo") Integer boardNo) {
        log.info("boardNoCommentList()");

        return service.boardNoCommentList(boardNo);
    }
}
