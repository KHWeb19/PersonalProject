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
    public void QuestionBoardRegister (@Validated @RequestBody QuestionBoard board) {
        log.info("QuestionBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<QuestionBoard> QuestionBoardList () {
        log.info("QuestionBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public QuestionBoard QuestionBoardRead (
            @PathVariable("QuestionBoardNo") Integer BoardNo) {
        log.info("QuestionBoardRead()");

        return service.read(BoardNo);
    }

    @PutMapping("/{boardNo}")
    public QuestionBoard QuestionBoardModify (
            @PathVariable("QuestionBoardNo") Integer BoardNo,
            @RequestBody QuestionBoard QuestionBoard) {
        log.info("QuestionBoardModify(): " + QuestionBoard);

        QuestionBoard.setBoardNo(Long.valueOf(BoardNo));
        service.modify(QuestionBoard);

        return QuestionBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void QuestionBoardRemove (
            @PathVariable("QuestionBoardNo") Integer BoardNo) {
        log.info("QuestionBoardRemove()");

        service.remove(BoardNo);
    }

}
