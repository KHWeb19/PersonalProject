package com.example.demo.controller;

import com.example.demo.entity.Board.Comment;
import com.example.demo.service.Board.CommentService;
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

    @PostMapping("/{boardNo}")
    public void CommentRegister (@Validated @RequestBody Comment comment,
                                 @PathVariable("boardNo") Long boardNo) {
        log.info("CommentRegister()");

        service.register(comment, boardNo);
    }

    @GetMapping("/{boardNo}")
    public List<Comment> list (@PathVariable("boardNo") Long boardNo) {
        log.info("CommentList()");

        return service.list(boardNo);
    }

    @DeleteMapping("/{commentNo}")
    public void CommentDelete (@PathVariable("commentNo") Long commentNo, Comment comment) {
        log.info("CommentDelete()");

        service.delete(commentNo);
    }
}
