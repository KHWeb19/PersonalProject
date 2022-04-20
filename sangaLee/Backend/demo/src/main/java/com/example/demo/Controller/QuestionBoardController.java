package com.example.demo.Controller;

import com.example.demo.entity.QuestionBoard;
import com.example.demo.service.Question.QuestionBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/QuestionBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class QuestionBoardController {

    @Autowired
    private QuestionBoardService service;

    @PostMapping("/register")
    public void jpaBoardRegister (@Validated @RequestBody QuestionBoard board) {
        log.info("jpaBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<QuestionBoard> jpaBoardList () {
        log.info("jpaBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public QuestionBoard jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public QuestionBoard jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody QuestionBoard jpaBoard) {
        log.info("jpaBoardModify(): " + jpaBoard);

        jpaBoard.setQuestionBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard);

        return jpaBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void jpaBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRemove()");

        service.remove(boardNo);
    }

}
