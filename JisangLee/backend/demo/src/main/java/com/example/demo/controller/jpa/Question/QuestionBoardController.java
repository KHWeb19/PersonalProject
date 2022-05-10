package com.example.demo.controller.jpa.Question;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.entity.jpa.Question.QuestionBoard;
import com.example.demo.service.jpa.Local.LocalBoardService;
import com.example.demo.service.jpa.Question.QuestionBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/questionboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class QuestionBoardController {

    @Autowired
    private QuestionBoardService service;

    @PostMapping("/register")
    public void questionBoardRegister (@Validated @RequestBody QuestionBoard board) {
        log.info("questionBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<QuestionBoard> questionBoardList () {
        log.info("questionBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public QuestionBoard questionBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("questionBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public QuestionBoard questionBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody QuestionBoard questionBoard) {
        log.info("questionBoardModify(): " + questionBoard);

        questionBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(questionBoard);

        return questionBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void localBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("localBoardRemove()");

        service.remove(boardNo);
    }
}