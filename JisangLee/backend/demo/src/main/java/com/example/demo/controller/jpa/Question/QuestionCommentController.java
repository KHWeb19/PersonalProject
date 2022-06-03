package com.example.demo.controller.jpa.Question;

import com.example.demo.entity.jpa.Local.LocalComment;
import com.example.demo.entity.jpa.Question.QuestionComment;
import com.example.demo.service.jpa.Local.LocalCommentService;
import com.example.demo.service.jpa.Question.QuestionCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/questionboard")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")

public class QuestionCommentController {
    @Autowired
    private QuestionCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated QuestionComment questionComment, @PathVariable ("boardNo") Integer boardNo){
        log.info("register" + questionComment);
        service.register(boardNo, questionComment);
    }

    @GetMapping("/{boardNo}/comment/list")
    public List<QuestionComment> read (@PathVariable("boardNo") Integer boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , QuestionComment questionComment){
        log.info("Comment remove()");
        service.delete(commentId);
    }
}
