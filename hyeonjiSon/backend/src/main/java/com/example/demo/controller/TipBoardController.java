package com.example.demo.controller;

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
}
