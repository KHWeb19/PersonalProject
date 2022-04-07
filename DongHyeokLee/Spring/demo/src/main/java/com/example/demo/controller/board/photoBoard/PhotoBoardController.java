package com.example.demo.controller.board.photoBoard;



import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.service.board.photoBoard.PhotoBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/photoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardController {

    @Autowired
    private PhotoBoardService service;

    @PostMapping("/register")
    public void PhotoBoardRegister (@Validated @RequestBody PhotoBoard photoBoard) {
        log.info("PhotoBoardRegister()");

        service.register(photoBoard);
    }

    @GetMapping("/list")
    public List<PhotoBoard> PhotoBoardList () {
        log.info("PhotoBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public PhotoBoard photoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRead()");

        return service.read(boardNo);
    }

}
