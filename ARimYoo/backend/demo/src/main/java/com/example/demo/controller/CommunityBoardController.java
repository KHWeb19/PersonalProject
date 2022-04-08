package com.example.demo.controller;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.service.board.CommunityBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService service;

    @PostMapping("/register")
    public void CommunityBoardRegister (@Validated @RequestBody CommunityBoard board) {
        log.info ("CommunityBoardRegister();");
        service.register(board);

    }

    @GetMapping("/list")
    public List<CommunityBoard> boardList () {
        log.info("CommunityBoardList");

        return service.list ();
    }

    @GetMapping("/{boardNo}")
    public CommunityBoard read (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("read()");

        return service.read(boardNo);
    }

}
