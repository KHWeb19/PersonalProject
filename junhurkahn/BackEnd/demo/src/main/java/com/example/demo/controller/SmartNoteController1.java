package com.example.demo.controller;


import com.example.demo.service.order62.JpaBoardServices1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.jpa.JpaBoards1;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board1")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController1 {

    @Autowired
    private JpaBoardServices1 service;

    @PostMapping("/register1")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards1 board) {
        log.info("jpaBoardRegister1()");

        service.register(board);
    }

    @GetMapping("/list1")
    public List<JpaBoards1> jpaBoardList (String keyword) {
        log.info("jpaBoardList1()");

        if (keyword == null) {
            return service.list();
        } else {
            return service.search(keyword);
        }

    }

    @GetMapping("/{boardNo}")
    public JpaBoards1 jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead1()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public JpaBoards1 jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody JpaBoards1 jpaBoard1) {
        log.info("jpaBoardModify1(): " + jpaBoard1);

        jpaBoard1.setBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard1);

        return jpaBoard1;
    }

    @DeleteMapping("/{boardNo}")
    public void jpaBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRemove1()");

        service.remove(boardNo);
    }
}