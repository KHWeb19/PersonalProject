package com.example.demo.controller;

import com.example.demo.entity.jpa.JpaBoards;


import com.example.demo.service.order62.JpaBoardServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController {

    @Autowired
    private JpaBoardServices service;

    @PostMapping("/register")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards board) {
        log.info("jpaBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<JpaBoards> jpaBoardList () {
        log.info("jpaBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public JpaBoards jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public JpaBoards jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody JpaBoards jpaBoard) {
        log.info("jpaBoardModify(): " + jpaBoard);

        jpaBoard.setBoardNo(Long.valueOf(boardNo));
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