package com.example.backend.controller;

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

    @PostMapping("/register/{boardNo}/{memberNo}")
    public void commentRegister(@PathVariable("boardNo") Integer boardNo, @PathVariable("memberNo") Integer memberNo, @Validated @RequestBody Comment comment) {
        log.info("commentRegister()"+memberNo);

        service.register(boardNo, memberNo, comment);
    }

    @GetMapping("/list/{boardNo}")
    public List<Comment> commentList(@PathVariable("boardNo") Integer boardNo) {
        log.info("commentList()");

        return service.list(boardNo);
    }

    @PutMapping("/{commentNo}")
    public Comment commentModify (
            @PathVariable("commentNo") Integer commentNo,
            @RequestBody Comment comment) {
        log.info("boardModify(): " + comment);

        comment.setCommentNo(Long.valueOf(commentNo));
        service.modify(comment);

        return comment;
    }

    @DeleteMapping("/{commentNo}")
    public void commentRemove (@PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
