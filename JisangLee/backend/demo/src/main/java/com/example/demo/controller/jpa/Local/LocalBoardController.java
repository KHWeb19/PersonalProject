package com.example.demo.controller.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.service.jpa.Local.LocalBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/localboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class LocalBoardController {

    @Autowired
    private LocalBoardService service;

    @PostMapping("/register")
    public void localBoardRegister (@Validated @RequestBody LocalBoard board) {
        log.info("localBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<LocalBoard> localBoardList () {
        log.info("localBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public LocalBoard localBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("localBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public LocalBoard localBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody LocalBoard localBoard) {
        log.info("localBoardModify(): " + localBoard);

        localBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(localBoard);

        return localBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void localBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("localBoardRemove()");

        service.remove(boardNo);
    }
}