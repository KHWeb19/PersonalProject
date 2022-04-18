package com.example.demo.controller.personalProject;

import com.example.demo.controller.request.CommentDto;
import com.example.demo.entity.personalProject.Comment;
import com.example.demo.entity.personalProject.QnABoard;
import com.example.demo.service.presonalProject.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CommentDto commentDto) {
        log.info("commentRegister()");

        Comment comment = commentService.register(commentDto);

        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @GetMapping("/read/{qnaNo}")
    public ResponseEntity read(@PathVariable Long qnaNo) {
        log.info("commentRead()");

        List<Comment> commentList = commentService.read(qnaNo);

        return new ResponseEntity(commentList, HttpStatus.OK);
    }

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) {
        log.info("commentReadOnly()");

        Comment comment = commentService.readOnly(commentNo);

        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo,
                                       @RequestBody CommentDto commentDto) {
        log.info("commentModify()");

        Comment comment = commentService.readOnly(commentNo);
        commentService.modify(comment, commentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo){
        log.info("commentRemove()");

        Comment comment = commentService.readOnly(commentNo);
        commentService.remove(comment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
