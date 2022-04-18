package com.example.demo.controller.board.photoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.PhotoBoardCommentResponse;
import com.example.demo.service.board.photoBoard.PhotoBoardCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/photoBoardComments")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardCommentsController {

    @Autowired
    private PhotoBoardCommentsService service;

    //댓글 등록
    @PostMapping("/register/{boardNo}")
    public void PhotoBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody CommentRequest commentRequest) {

        log.info("PhotoBoardCommentsRegister()" + commentRequest);
        //commentRequest.setBoardNo(Long.valueOf(boardNo));

        service.register(boardNo, commentRequest);
    }

    //댓글 목록
    @GetMapping("/list/{boardNo}")
    public List<PhotoBoardCommentResponse> PhotoBoardCommentsList (@PathVariable("boardNo") Integer boardNo) {
        log.info("PhotoBoardCommentsList()");

        return service.list(boardNo);
    }

    //댓글 수정
    @PutMapping("/{commentNo}")
    public PhotoBoardCommentResponse photoBoardCommentModify (
            @PathVariable("commentNo") Integer commentNo,
            @Validated @RequestBody CommentRequest commentRequest) {
        log.info("photoBoardCommentModify(): " + commentRequest);


        return service.modify(commentNo, commentRequest);

    }


    //댓글 삭제
    @DeleteMapping("/{commentNo}")
    public void PhotoBoardCommentRemove (
            @PathVariable("commentNo") Integer commentNo) {
        log.info("commentRemove()");

        service.remove(commentNo);
    }
}
