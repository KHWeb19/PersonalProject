package com.example.demo.controller;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.entity.board.CommunityCommentBox;
import com.example.demo.service.board.CommunityCommentBoxService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityCommentBoxController {

    @Autowired
    private CommunityCommentBoxService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated CommunityCommentBox communityCommentBox, @PathVariable ("boardNo") Long boardNo
                          ){
        log.info("register" + communityCommentBox);
        service.register(boardNo, communityCommentBox);

    }

    @GetMapping("/{boardNo}/comment/list")
    public List<CommunityCommentBox> read (@PathVariable("boardNo") Long boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , CommunityCommentBox communityCommentBox) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
