package com.example.demo.controller.board.photoBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.service.board.photoBoard.PhotoBoardService;
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
@RequestMapping("/photoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardController {

    @Autowired
    private PhotoBoardService service;

    //등록
    @PostMapping(value = "/register",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void PhotoBoardRegister ( @RequestPart(value="board") PhotoBoard board,
                                     @RequestPart(value="files") MultipartFile files) throws Exception {
        log.info("PhotoBoardRegister()" + board + "file" + files);

       service.register(board, files);
    }
    //목록
    @GetMapping("/list")
    public List<PhotoBoard> PhotoBoardList () {
        log.info("PhotoBoardList()");

        return service.list();
    }
    //읽기
    @GetMapping("/{boardNo}")
    public PhotoBoard photoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRead()");

        return service.read(boardNo);
    }

    //수정
    @PutMapping(value = "/{boardNo}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public PhotoBoard photoBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestPart(value="board") PhotoBoard board,
            @RequestPart(value="files", required = false) MultipartFile files) throws Exception {
        log.info("photoBoardModify(): " + board + "boardNo" + boardNo);

            board.setBoardNo(Long.valueOf(boardNo));
            service.modify(boardNo, board, files);

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void photoBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRemove()");

        //service.removeFile(boardNo);
        service.remove(boardNo);

    }

}
