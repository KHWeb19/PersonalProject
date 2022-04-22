package com.example.demo.controller.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoardComment;
import com.example.demo.service.FoodBoard.FoodBoardCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foodBoard/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FoodBoardCommentController {

    @Autowired
    private FoodBoardCommentService service;

    @PostMapping("/register/{boardNo}")
    public void foodBoardCommentRegister(@Validated @RequestBody FoodBoardComment foodBoardComment, @PathVariable("boardNo") Long boardNo){
        log.info("foodBoardCommentRegister" +foodBoardComment);
        service.register(foodBoardComment, boardNo);
    }

    @GetMapping("/list/{boardNo}")
    public List<FoodBoardComment> list(@PathVariable("boardNo")Long boardNo){
        log.info("commentList()");

        return service.list(boardNo);
    }

    @DeleteMapping("/{commentNo}")
    public void delete (@PathVariable("commentNo") Long commentNo,FoodBoardComment foodBoardComment){
        log.info("commentRemove()");

        service.delete(commentNo);
    }
}
