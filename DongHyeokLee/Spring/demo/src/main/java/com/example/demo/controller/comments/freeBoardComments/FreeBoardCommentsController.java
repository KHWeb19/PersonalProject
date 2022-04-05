package com.example.demo.controller.comments.freeBoardComments;



import com.example.demo.controller.comments.freeBoardComments.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;
import com.example.demo.service.comments.freeBoardComments.FreeBoardCommentsService;
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
                                            @Validated @RequestBody FreeBoardCommentsRequest commentsRequest) {

        log.info("FreeBoardCommentsRegister()" + commentsRequest);
        commentsRequest.setBoardNo(Long.valueOf(boardNo));

        service.register(commentsRequest);
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
            @RequestBody FreeBoardComments freeBoardComments) {
        log.info("freeBoardCommentModify(): " + freeBoardComments);

        freeBoardComments.setCommentNo(Long.valueOf(commentNo));
        service.modify(freeBoardComments);

        return freeBoardComments;
    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void freeBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
