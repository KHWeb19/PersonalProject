package com.example.demo.controller;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.service.board.CommunityBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService service;

    @PostMapping("/register")
    public void CommunityBoardRegister (@Validated CommunityBoard board, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("CommunityBoardRegister();" + file);
        service.register(board, file);

    }

    @GetMapping("/list")
    public List<CommunityBoard> boardList () {
        log.info("CommunityBoardList");

        return service.list ();
    }

    @GetMapping("/{boardNo}")
    public CommunityBoard read (
            @PathVariable("boardNo") Long boardNo) {
        log.info("read()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public CommunityBoard modify (
            @PathVariable("boardNo") Integer boardNo,
             CommunityBoard communityBoard, @RequestParam(required = false) MultipartFile file) throws Exception  {
        log.info("modify(): " + communityBoard);

        communityBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(communityBoard, file);

        return communityBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void remove(
            @PathVariable("boardNo") Integer boardNo, CommunityBoard communityBoard) throws Exception  {
        log.info("remove()");
        service.remove(boardNo);

    }

}