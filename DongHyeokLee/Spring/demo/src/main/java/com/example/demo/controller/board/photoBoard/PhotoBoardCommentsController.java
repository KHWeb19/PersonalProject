package com.example.demo.controller.board.photoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
import com.example.demo.service.board.BaseCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/photoBoardComments")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardCommentsController {

    @Autowired
    private BaseCommentService photoBoardCommentsServiceImpl;

    //댓글 등록
    @PostMapping("/register/{boardNo}")
    public void photoBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentRequest) {

        log.info("PhotoBoardCommentsRegister()" + commentRequest);
        //commentRequest.setBoardNo(Long.valueOf(boardNo));

        photoBoardCommentsServiceImpl.register(boardNo, commentRequest);
    }

    //댓글 목록
    @GetMapping("/list/{boardNo}")
    public Object photoBoardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("PhotoBoardCommentsList()");

        return photoBoardCommentsServiceImpl.list(boardNo);
    }

    //댓글 수정
    @PutMapping("/{commentNo}")
    public Object photoBoardCommentModify (
            @PathVariable("commentNo") Integer commentNo,
            @Validated @RequestBody CommentRequest commentRequest) {
        log.info("photoBoardCommentModify(): " + commentRequest);


        return photoBoardCommentsServiceImpl.modify(commentNo, commentRequest);

    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void photoBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        photoBoardCommentsServiceImpl.remove(commentNo);
    }

    @PostMapping("reply/register/{boardNo}")
    public void photoBoardReplyRegister (@PathVariable("boardNo") Integer boardNo,
                                        @Validated @RequestBody ReplyRequest commentRequest) {

        log.info("FreeBoardReplyRegister()" + commentRequest);

        photoBoardCommentsServiceImpl.replyRegister(boardNo, commentRequest);
    }
}
