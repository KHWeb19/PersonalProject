package com.example.demo.controller;


import com.example.demo.entity.jpa.JpaBoards2;
import com.example.demo.service.order62.JpaBoardServices2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board2")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController2 {

    @Autowired
    private JpaBoardServices2 service;

    @PostMapping("/register2")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards2 board) {
        log.info("jpaBoardRegister2()");

        service.register(board);
    }

    @GetMapping("/list2")
    public List<JpaBoards2> jpaBoardList () {
        log.info("jpaBoardList2()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public JpaBoards2 jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead2()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public JpaBoards2 jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody JpaBoards2 jpaBoard2) {
        log.info("jpaBoardModify2(): " + jpaBoard2);

        jpaBoard2.setBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard2);

        return jpaBoard2;
    }

    @DeleteMapping("/{boardNo}")
    public void jpaBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRemove2()");

        service.remove(boardNo);
    }
}