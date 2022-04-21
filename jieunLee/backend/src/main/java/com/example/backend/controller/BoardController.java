package com.example.backend.controller;

import com.example.backend.entity.Board;
import com.example.backend.service.BoardService;
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

    @PostMapping("/register/{memberNo}")
    public void boardRegister(@PathVariable("memberNo") Integer memberNo, @Validated @RequestBody Board board) {
        log.info("boardRegister()" + board);

        service.register(memberNo, board);
    }

    @GetMapping("/list")
    public List<Board> boardList() {
        log.info("boardList()");

        return service.list();
    }

    @GetMapping("/list/{memberNo}")
    public List<Board> memberBoardList(@PathVariable("memberNo") Long memberNo) {
        log.info("memberBoardList()");

        return service.memberBoardList(memberNo);
    }

    @GetMapping("/{boardNo}")
    public Board boardRead(@PathVariable("boardNo") Integer boardNo) {
        log.info("boardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{memberNo}/{boardNo}")
    public Board boardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody Board board,
            @PathVariable("memberNo") Integer memberNo) {
        log.info("boardModify(): " + board);

        board.setBoardNo(Long.valueOf(boardNo));
        service.modify(board, memberNo);


        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }

}
