package com.example.backend.controller.board;


import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.entity.BoardComments;
import com.example.backend.service.board.BoardCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boardComments")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class BoardCommentsController {

    @Autowired
    private BoardCommentsService service;

    @PostMapping("/register/{boardNo}")
    public void boardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentRequest) {

        log.info("boardCommentsRegister()" + commentRequest);

        service.register(boardNo, commentRequest);
    }


    @GetMapping("/list/{boardNo}")
    public List<BoardComments> boardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("boardCommentsList()");

        return service.list(boardNo);
    }


    @PutMapping("/{commentNo}")
    public BoardComments boardCommentsModify (
            @PathVariable("commentNo") Integer commentNo,
            @Validated @RequestBody CommentRequest commentRequest) {
        log.info("boardCommentModify(): " + commentRequest);


        return service.modify(commentNo, commentRequest);

    }



    @DeleteMapping("/{commentNo}")
    public void boardCommentsRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}




