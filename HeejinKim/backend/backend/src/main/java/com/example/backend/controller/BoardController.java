package com.example.backend.controller;

import com.example.backend.entity.Board;
import com.example.backend.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @PostMapping("/register")
    public void BoardRegister(@Validated Board board, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("BoardRegister()" + file);

        service.register(board, file);

    }

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("BoardList()");

        return service.list ();
    }

    @GetMapping("/{boardNo}")
    public Board boardRead (
            @PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");
        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board boardModify (
            @PathVariable("boardNo") Integer boardNo,Board board,
            @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("boardModify(): " + board);

        board.setBoardNo(Long.valueOf(boardNo));
        service.modify(board,file);

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove(
            @PathVariable("boardNo") Integer boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }
}

