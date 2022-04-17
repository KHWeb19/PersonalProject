package com.example.demo.controller.board.videoBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.videoBoard.VideoBoardComments;
import com.example.demo.service.board.videoBoard.VideoBoardCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/videoBoardComments")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VideoBoardCommentsController {

    @Autowired
    private VideoBoardCommentsService service;

    //댓글 등록
    @PostMapping("/register/{boardNo}")
    public void VideoBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentsRequest) {

        log.info("FreeBoardCommentsRegister()" + commentsRequest);
        commentsRequest.setBoardNo(Long.valueOf(boardNo));

        service.register(commentsRequest);
    }

    //댓글 목록
    @GetMapping("/list/{boardNo}")
    public List<VideoBoardComments> VideoBoardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("VideoBoardCommentsList()");

        return service.list(boardNo);
    }

    //댓글 수정
    @PutMapping("/{commentNo}")
    public VideoBoardComments VideoBoardCommentModify (
            @PathVariable("commentNo") Integer commentNo,
            @RequestBody VideoBoardComments videoBoardComments) {
        log.info("freeBoardCommentModify(): " + videoBoardComments);

        videoBoardComments.setCommentNo(Long.valueOf(commentNo));
        service.modify(videoBoardComments);

        return videoBoardComments;
    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void PhotoBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
