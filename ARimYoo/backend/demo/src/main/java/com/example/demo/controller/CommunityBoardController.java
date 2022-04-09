package com.example.demo.controller;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.entity.board.CommunityPhoto;
import com.example.demo.service.board.CommunityBoardService;
import com.example.demo.service.board.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService service;

    @Autowired
    private PhotoService photoService;

    @PostMapping("/register")
    public void CommunityBoardRegister (@Validated CommunityBoard board, @RequestParam("file") MultipartFile file) throws Exception {
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
            @RequestBody CommunityBoard communityBoard) {
        log.info("modify(): " + communityBoard);

        communityBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(communityBoard);

        return communityBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void remove(
            @PathVariable("boardNo") Integer boardNo) {
        log.info("remove()");

        service.remove(boardNo);

    }

}
