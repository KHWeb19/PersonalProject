package com.example.backend.controller.board;


import com.example.backend.controller.board.request.KeyWordRequest;
import com.example.backend.entity.Board;
import com.example.backend.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;


    @PostMapping("/register")
    public void boardRegister (@Validated Board board, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("boardRegister()" + board + "file" + file);

        service.register(board, file);
    }

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("BoardList()");

        return service.list ();
    }

    @GetMapping("/{boardNo}")
    public Board boardRead (
            @PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");
        return service.read(boardNo);
    }


    @PutMapping("/{boardNo}")
    public Board boardModify (
            @PathVariable("boardNo") Integer boardNo,
            Board board, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("boardModify(): " + board + "boardNo" + boardNo);

        board.setBoardNo(Long.valueOf(boardNo));
        service.modify(board, file);

        return board;
    }


    @DeleteMapping("/{boardNo}")
    public void boardRemove(
            @PathVariable("boardNo") Integer boardNo,Board board) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }

    @PostMapping("/search")
    public List<Board> boardSearchList (@RequestBody KeyWordRequest keyWord) {
        log.info("boardSearchList()"+keyWord );
        String key = keyWord.getKeyWord();

        return service.searchList(key);
    }
}

