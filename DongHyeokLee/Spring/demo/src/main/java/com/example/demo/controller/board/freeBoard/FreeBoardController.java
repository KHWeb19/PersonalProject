package com.example.demo.controller.board.freeBoard;


import com.example.demo.dto.KeyWordRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.service.board.freeBoard.FreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/freeBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FreeBoardController {

    @Autowired
    private FreeBoardService service;

    //등록
    @PostMapping("/register")
    public void FreeBoardRegister (@Validated @RequestBody FreeBoard freeBoard) {
        log.info("FreeBoardRegister()");

        service.register(freeBoard);
    }
    //목록
    @GetMapping("/list")
    public List<FreeBoard> FreeBoardList () {
        log.info("FreeBoardList()");

        return service.list();
    }

    //읽기
    @GetMapping("/{boardNo}")
    public FreeBoard freeBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("freeBoardRead()");

        return service.read(boardNo);
    }
    //수정
    @PutMapping("/{boardNo}")
    public FreeBoard freeBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody FreeBoard board) {
        log.info("Modify: ");

        return service.modify(boardNo, board);

    }
    //삭제
    @DeleteMapping("/{boardNo}")
    public void freeBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("freeBoardRemove()");

        service.remove(boardNo);
    }

    @PostMapping("/search")
    public List<FreeBoard> FreeBoardSearchList (@RequestBody KeyWordRequest keyWord) {
        log.info("FreeBoardSearchList()");
        String word = keyWord.getKeyWord();

        return service.searchList(word);
    }
}
