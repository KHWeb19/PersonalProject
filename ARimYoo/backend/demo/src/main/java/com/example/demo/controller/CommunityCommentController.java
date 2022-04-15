package com.example.demo.controller;

import com.example.demo.entity.communityBoard.CommunityCommentBox;
import com.example.demo.service.communityBoard.CommunityCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityCommentController {

    @Autowired
    private CommunityCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated CommunityCommentBox communityComment, @PathVariable ("boardNo") Long boardNo
                          ){
        log.info("register" + communityComment);
        service.register(boardNo, communityComment);

    }

    @GetMapping("/{boardNo}/comment/list")
    public List<CommunityCommentBox> read (@PathVariable("boardNo") Long boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , CommunityCommentBox communityComment) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
