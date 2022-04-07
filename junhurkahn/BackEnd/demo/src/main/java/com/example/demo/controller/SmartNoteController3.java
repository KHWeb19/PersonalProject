package com.example.demo.controller;


import com.example.demo.entity.jpa.JpaBoards3;
import com.example.demo.service.order62.JpaBoardServices3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board3")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController3 {

    @Autowired
    private JpaBoardServices3 service;

    @PostMapping("/register3")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards3 board) {
        log.info("jpaBoardRegister2()");

        service.register(board);
    }

    @GetMapping("/list3")
    public List<JpaBoards3> jpaBoardList () {
        log.info("jpaBoardList3()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public JpaBoards3 jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead3()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public JpaBoards3 jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody JpaBoards3 jpaBoard3) {
        log.info("jpaBoardModify3(): " + jpaBoard3);

        jpaBoard3.setBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard3);

        return jpaBoard3;
    }

    @DeleteMapping("/{boardNo}")
    public void jpaBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRemove3()");

        service.remove(boardNo);
    }
}