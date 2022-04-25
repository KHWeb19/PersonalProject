package com.example.demo.controller;

import com.example.demo.controller.request.MemberSearchRequest;
import com.example.demo.controller.request.TipSearchRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.TipBoard;
import com.example.demo.service.TipBoard.TipBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tipboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TipBoardController {

    @Autowired
    private TipBoardService service;

    @PostMapping("/register")
    public void tipBoardRegister (@Validated @RequestBody TipBoard board) {
        log.info("tipBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<TipBoard> tipBoardList () {
        log.info("TipBoardList()");

        return service.list();
    }

    @GetMapping("getTipBoardList")
    public List<TipBoard> getTipBoardList(){
        log.info("getTipBoardList()");
        return service.getTipBoardList();
    }

    @PostMapping("/search")
    public List<TipBoard> searchTipBoard(@RequestBody TipSearchRequest tipSearchRequest){
        log.info("search()" + tipSearchRequest);
        String keyWord = tipSearchRequest.getKeyWord();
        return service.searchList(keyWord);

    }

    @GetMapping("/{boardNo}")
    public TipBoard tipBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("tipBoardRead()");

        return service.read(boardNo);
    }

    //비밀번호 대조

    @PutMapping("/{boardNo}")
    public TipBoard tipBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody TipBoard tipBoard) {
        log.info("tipBoardModify(): " + tipBoard);

        tipBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(tipBoard);

        return tipBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void tipBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("tipBoardRemove()");

        service.remove(boardNo);
    }
}
