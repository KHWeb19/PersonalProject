package com.example.demo.controller.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignComment;
import com.example.demo.service.jpa.Foreign.ForeignCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foreignboard")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")

public class ForeignCommentController {
    @Autowired
    private ForeignCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated ForeignComment foreignComment, @PathVariable ("boardNo") Integer boardNo){
        log.info("register" + foreignComment);
        service.register(boardNo, foreignComment);
    }

    @GetMapping("/{boardNo}/comment/list")
    public List<ForeignComment> read (@PathVariable("boardNo") Integer boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , ForeignComment foreignComment){
        log.info("Comment remove()");
        service.delete(commentId);
    }
}
