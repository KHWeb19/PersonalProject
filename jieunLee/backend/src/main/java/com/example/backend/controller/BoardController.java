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

    @PostMapping("/register")
    public void boardRegister(@Validated @RequestBody Board board) {
        log.info("boardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<Board> boardList() {
        log.info("boardList()");

        return service.list();
    }
}
