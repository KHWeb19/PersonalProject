package com.example.demo.controller.board.videoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.service.board.BaseCommentService;
import com.example.demo.service.board.videoBoard.VideoBoardCommentsServiceImpl;
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
    private BaseCommentService videoBoardCommentsServiceImpl;

    //댓글 등록
    @PostMapping("/register/{boardNo}")
    public void VideoBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentsRequest) {

        log.info("FreeBoardCommentsRegister()" + commentsRequest);


        videoBoardCommentsServiceImpl.register(boardNo, commentsRequest);
    }

    //댓글 목록
    @GetMapping("/list/{boardNo}")
    public Object VideoBoardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("VideoBoardCommentsList()");

        return videoBoardCommentsServiceImpl.list(boardNo);
    }

    //댓글 수정
    @PutMapping("/{commentNo}")
    public Object VideoBoardCommentModify (
            @PathVariable("commentNo") Integer commentNo,
            @Validated @RequestBody CommentRequest commentRequest) {
        log.info("freeBoardCommentModify(): " + commentRequest);

        return videoBoardCommentsServiceImpl.modify(commentNo, commentRequest);
    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void PhotoBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        videoBoardCommentsServiceImpl.remove(commentNo);
    }

    @PostMapping("reply/register/{boardNo}")
    public void photoBoardReplyRegister (@PathVariable("boardNo") Integer boardNo,
                                         @Validated @RequestBody ReplyRequest commentRequest) {

        log.info("FreeBoardReplyRegister()" + commentRequest);

        videoBoardCommentsServiceImpl.replyRegister(boardNo, commentRequest);
    }
}
