package com.example.demo.Controller;


import com.example.demo.entity.QuestionComment;
import com.example.demo.request.QuestionCommentDto;
import com.example.demo.service.QuestionCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Question/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class QuestionCommentController {

    @Autowired
    private QuestionCommentService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody QuestionCommentDto questionCommentDto) throws Exception {
        log.info("Comment Register");

        QuestionComment questionComment = service.add(questionCommentDto);

        return new ResponseEntity(questionComment, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable Long boardNo) throws Exception {
        log.info("Comment Read");

        List<QuestionComment> questionComments = service.read(boardNo);

        return new ResponseEntity(questionComments, HttpStatus.OK);
    }

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Read Only");

        QuestionComment questionComment =  service.readOnly(commentNo);

        return new ResponseEntity(questionComment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo, @RequestBody QuestionCommentDto questionCommentDto) throws Exception {
        log.info("Comment Modify");

        QuestionComment questionComment = service.readOnly(commentNo);

        service.modify(questionComment, questionCommentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Remove");

        QuestionComment questionComment = service.readOnly(commentNo);

        service.remove(questionComment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


















