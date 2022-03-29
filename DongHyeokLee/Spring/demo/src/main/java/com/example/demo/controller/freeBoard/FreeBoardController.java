package com.example.demo.controller.freeBoard;


import com.example.demo.entitiy.freeBoard.FreeBoard;
import com.example.demo.service.freeBoard.FreeBoardService;
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

    @PostMapping("/register")
    public void FreeBoardRegister (@Validated @RequestBody FreeBoard freeBoard) {
        log.info("FreeBoardRegister()");

        service.register(freeBoard);
    }

    @GetMapping("/list")
    public List<FreeBoard> FreeBoardList () {
        log.info("FreeBoardList()");

        return service.list();
    }
}
