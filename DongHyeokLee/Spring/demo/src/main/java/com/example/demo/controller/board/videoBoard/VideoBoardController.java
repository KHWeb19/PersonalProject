package com.example.demo.controller.board.videoBoard;

import com.example.demo.dto.Board;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.entitiy.board.videoBoard.VideoBoard;
import com.example.demo.service.board.videoBoard.VideoBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/videoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VideoBoardController {

    @Autowired
    private VideoBoardService service;

    //등록
    @PostMapping(value = "/register",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void VideoBoardRegister ( @RequestPart(value="board") Board board,
                                     @RequestPart(value="files") MultipartFile files) throws Exception {
        log.info("VideoBoardRegister()" + board + "file" + files);

        service.register(board, files);
    }
    //목록
    @GetMapping("/list")
    public List<VideoBoard> VideoBoardList () {
        log.info("VideoBoardList()");

        return service.list();
    }
    //읽기
    @GetMapping("/{boardNo}")
    public VideoBoard videoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("videoBoardRead()");

        return service.read(boardNo);
    }
    //파일 업로드

    //수정
    @PutMapping(value = "/{boardNo}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Board videoBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestPart(value="board") Board board,
            @RequestPart(value="files", required = false) MultipartFile files) throws Exception {
        log.info("videoBoardModify(): " + board + "boardNo" + boardNo);

        board.setBoardNo(Long.valueOf(boardNo));
        service.modify(boardNo, board, files);

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void videoBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("videoBoardRemove()");

        service.remove(boardNo);
    }

}
