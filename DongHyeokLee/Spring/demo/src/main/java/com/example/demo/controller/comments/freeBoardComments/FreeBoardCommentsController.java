package com.example.demo.controller.comments.freeBoardComments;



import com.example.demo.controller.comments.freeBoardComments.request.FreeBoardCommentsRequest;
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

    @PostMapping("/register/{boardNo}")
    public void freeBoardCommentsRegister ( @PathVariable("boardNo") Integer boardNo,
                                            @Validated @RequestBody FreeBoardCommentsRequest commentsRequest) {

        log.info("FreeBoardCommentsRegister()" + commentsRequest);
        commentsRequest.setBoardNo(Long.valueOf(boardNo));

        service.register(commentsRequest);
    }

    @GetMapping("/list")
    public List<FreeBoardComments> FreeBoardCommentsList () {
        log.info("FreeBoardCommentsList()");

        return service.list();
    }
}
