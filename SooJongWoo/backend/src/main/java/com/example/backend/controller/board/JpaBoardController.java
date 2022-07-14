package com.example.backend.controller.board;

import com.example.backend.entity.jpa.Board;
import com.example.backend.repository.jpa.JpaBoardRepository;
import com.example.backend.service.jpa.JpaBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaBoardController {

    @Autowired
    private JpaBoardService service;

    @Autowired
    private JpaBoardRepository boardRepository;

    @GetMapping("/lists")
    public ResponseEntity<List<Board>> getLists () throws Exception {
        log.info("getLists(): " + service.list());
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
        log.info("post register request from vue");

        service.register(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }


    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Board board = service.read(boardNo);

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Board> modify(@PathVariable("boardNo") Long boardNo,
                                        @Validated @RequestBody Board board ) throws Exception {


        Optional<Board> modifyBoard = boardRepository.findById(boardNo);

        modifyBoard.ifPresent( changeBoard ->{
            changeBoard.setTitle(board.getTitle());
            changeBoard.setContent(board.getContent());
            board.setBoardNo(boardNo);
            boardRepository.save(changeBoard);
        });

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
