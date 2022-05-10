package com.example.demo.controller.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalComment;
import com.example.demo.service.jpa.Local.LocalCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/localboard")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")

public class LocalCommentController {
    @Autowired
    private LocalCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated LocalComment localComment, @PathVariable ("boardNo") Integer boardNo){
        log.info("Comment register()" + localComment);
        service.register(boardNo, localComment);
    }

    @GetMapping("/{boardNo}/comment/list")
    public List<LocalComment> read (@PathVariable("boardNo") Integer boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , LocalComment localComment){
        log.info("Comment remove()");
        service.delete(commentId);
    }
}
