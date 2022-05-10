package com.example.demo.controller.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignBoard;
import com.example.demo.service.jpa.Foreign.ForeignBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foreignboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ForeignBoardController {

    @Autowired
    private ForeignBoardService service;

    @PostMapping("/register")
    public void foreignBoardRegister (@Validated @RequestBody ForeignBoard board) {
        log.info("foreignBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<ForeignBoard> foreignBoardList () {
        log.info("localBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public ForeignBoard foreignBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("foreignBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public ForeignBoard foreignBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody ForeignBoard foreignBoard) {
        log.info("foreignBoardModify(): " + foreignBoard);

        foreignBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(foreignBoard);

        return foreignBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void localBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("localBoardRemove()");

        service.remove(boardNo);
    }

}

