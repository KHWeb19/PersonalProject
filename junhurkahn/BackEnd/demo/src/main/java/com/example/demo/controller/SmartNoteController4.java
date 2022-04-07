package com.example.demo.controller;


import com.example.demo.entity.jpa.JpaBoards4;
import com.example.demo.service.order62.JpaBoardServices4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/62th/board4")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SmartNoteController4 {

    @Autowired
    private JpaBoardServices4 service;

    @PostMapping("/register4")
    public void jpaBoardRegister (@Validated @RequestBody JpaBoards4 board) {
        log.info("jpaBoardRegister4()");

        service.register(board);
    }

    @GetMapping("/list4")
    public List<JpaBoards4> jpaBoardList () {
        log.info("jpaBoardList4()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public JpaBoards4 jpaBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRead4()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public JpaBoards4 jpaBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody JpaBoards4 jpaBoard4) {
        log.info("jpaBoardModify4(): " + jpaBoard4);

        jpaBoard4.setBoardNo(Long.valueOf(boardNo));
        service.modify(jpaBoard4);

        return jpaBoard4;
    }

    @DeleteMapping("/{boardNo}")
    public void jpaBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("jpaBoardRemove4()");

        service.remove(boardNo);
    }
}