package com.example.backend.controller;

import com.example.backend.controller.member.request.BoardRequest;
import com.example.backend.entity.Board;
import com.example.backend.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/board/community")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @PostMapping("/register")
    public void BoardRegister(@Validated @RequestBody Board board) throws Exception {
        log.info("BoardRegister()");

        service.register(board);

    }
    @ResponseBody
    @PostMapping("/uploadImg/{randomNumToString}")
    public String requestUploadFile ( @RequestParam("fileList") List<MultipartFile> fileList,
                                      @PathVariable("randomNumToString") String randomNumToString ) {

        System.out.println("randomNumToString =" +randomNumToString);
        log.info("requestUploadFile(): " + fileList);


        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());


                FileOutputStream writer = new FileOutputStream(
                        "../../frontend_pro/src/assets/unloadImg/"
                                +randomNumToString+ multipartFile.getOriginalFilename());


                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!";
        }

        log.info("requestUploadFile(): Success!");

        return "Upload Success!";
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
            @PathVariable("boardNo") Integer boardNo, Board board,
            @RequestParam("fileList") List<MultipartFile> fileList) throws Exception {
        log.info("boardModify(): " + board);

        board.setBoardNo(Long.valueOf(boardNo));



        if (board.getFileName().equals(Optional.empty())) {
            Path filePath = Paths.get("c:\\PersonalProject\\PersonalProject-1\\HeejinKim\\frontend\\frontend_pro\\src\\assets\\unloadImg\\" + board.getFileName());
            Files.delete(filePath);
        }

        String checkFileName = board.getFileName();


        if(checkFileName != null){
            LocalDate date = LocalDate.now();
            String fileName = date + board.getFileName();
            board.setFileName(fileName);

        }

        service.modify(board, Long.valueOf(boardNo));

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove(
            @PathVariable("boardNo") Integer boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }
}

