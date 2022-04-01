package com.example.demo.controller;

import com.example.demo.entity.jpa.JpaBoards;

import com.example.demo.service.order63.JpaBoardServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board1")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController1 {

    @Autowired
    private JpaBoardServices service;

    @PostMapping("/register1")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards board) {
        log.info("jpaBoardRegister1()");

        service.register(board);
    }

    @GetMapping("/list1")
    public List<JpaBoards> jpaBoardList () {
        log.info("jpaBoardList1()");

        return service.list();
    }

    @GetMapping("/{boardNo1}")
    public JpaBoards jpaBoardRead (
            @PathVariable("boardNo1") Integer boardNo) {
        log.info("jpaBoardRead1()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo1}")
    public JpaBoards jpaBoardModify (
            @PathVariable("boardNo1") Integer boardNo,
            @RequestBody JpaBoards jpaBoard) {
        log.info("jpaBoardModify1(): " + jpaBoard);

        jpaBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard);

        return jpaBoard;
    }

    @DeleteMapping("/{boardNo1}")
    public void jpaBoardRemove (
            @PathVariable("boardNo1") Integer boardNo) {
        log.info("jpaBoardRemove1()");

        service.remove(boardNo);
    }
}