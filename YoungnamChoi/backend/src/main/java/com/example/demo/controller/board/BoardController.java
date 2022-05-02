package com.example.demo.controller.board;


import com.example.demo.entity.board.Board;
import com.example.demo.service.board.BoardService;
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
    public void BoardRegister (@Validated @RequestBody Board board) {
        log.info("BoardRegister()");

        service.register(board);
    }
    @GetMapping("/list")
    public List<Board> BoardList () {
        log.info("BoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public Board BoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("BoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board BoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody Board Board) {
        log.info("BoardModify(): " + Board);

        Board.setBoardNo(Long.valueOf(boardNo));
        service.modify(Board);

        return Board;
    }

    @DeleteMapping("/{boardNo}")
    public void BoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("BoardRemove()");

        service.remove(boardNo);
    }
}
