package com.example.demo.controller.board.freeBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.example.demo.service.board.freeBoard.FreeBoardCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/freeBoardComments")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FreeBoardCommentsController {

    @Autowired
    private FreeBoardCommentsService service;

    //댓글 등록
    @PostMapping("/register/{boardNo}")
    public void freeBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentRequest) {

        log.info("FreeBoardCommentsRegister()" + commentRequest);
        //commentsRequest.setBoardNo(Long.valueOf(boardNo));

        service.register(boardNo, commentRequest);
    }

    //댓글 목록
    @GetMapping("/list/{boardNo}")
    public List<FreeBoardComments> FreeBoardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("FreeBoardCommentsList()");

        return service.list(boardNo);
    }

    //댓글 수정
    @PutMapping("/{commentNo}")
    public FreeBoardComments freeBoardCommentModify (
            @PathVariable("commentNo") Integer commentNo,
            @Validated @RequestBody CommentRequest commentRequest) {
        log.info("freeBoardCommentModify(): " + commentRequest);


       return service.modify(commentNo, commentRequest);

    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void freeBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
