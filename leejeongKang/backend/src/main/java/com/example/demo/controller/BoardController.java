package com.example.demo.controller;


import com.example.demo.entity.Board.Board;
import com.example.demo.service.Board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @PostMapping("/register")
    public void BoardRegister (@Validated @RequestBody Board board){
        log.info("BoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<Board> BoardList() {
        log.info("BoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public Board BoardRead (@PathVariable("boardNo") Integer boardNo){
        log.info("BoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board BoardModify (@PathVariable("boardNo") Long boardNo,
                            @RequestBody Board board) {
        log.info("BoardModify(): " + board);

        board.setBoardNo(Long.valueOf(boardNo));
        service.modify(board);

        return board;
    }

}
