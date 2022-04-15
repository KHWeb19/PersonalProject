package com.example.demo.controller;

import com.example.demo.entity.StoreBoard;
import com.example.demo.entity.TipBoard;
import com.example.demo.service.StoreBoard.StoreBoardService;
import com.example.demo.service.TipBoard.TipBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/storeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class StoreBoardController {

    @Autowired
    private StoreBoardService service;

    @PostMapping("/register")
    public void storeBoardRegister (@Validated @RequestBody StoreBoard board) {
        log.info("storeBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<StoreBoard> storeBoardList () {
        log.info("StoreBoardList()");

        return service.list();
    }

}
