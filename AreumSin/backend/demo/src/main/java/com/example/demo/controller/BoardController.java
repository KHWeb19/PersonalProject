package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.request.BoardCommentRequest;
import com.example.demo.response.BoardCommentResponse;
import com.example.demo.response.BoardImgResponse;
import com.example.demo.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/register")
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList,
                                    @RequestParam("title") String title,
                                    @RequestParam("place") String place,
                                    @RequestParam("writer") String writer,
                                    @RequestParam("boardContent") String boardContent){

        List<String> fileName = new ArrayList<>();
        log.info("fileList() "+fileList);

        try{
            for(MultipartFile multipartFile : fileList){
                log.info("requestUploadFile() - Make file: " + multipartFile.getOriginalFilename());

                FileOutputStream file = new FileOutputStream("../../frontend/src/assets/uploadImg/" + writer + "_" + multipartFile.getOriginalFilename());

                String fileSrc = writer + "_" + multipartFile.getOriginalFilename();
                fileName.add(fileSrc);

                file.write(multipartFile.getBytes());
                file.close();
            }
        } catch (Exception e){
            log.info("fail");
            return "Upload Fail!!!";
        }

        boardService.register(fileName, title, place, writer, boardContent);

        return "Upload Success!!!";
    }

    @PostMapping("/list")
    public List<Board> boardList(){
        log.info("boardList()");

        return boardService.list();
    }

    @GetMapping("/read/{boardNo}")
    public Board boardRead( @PathVariable("boardNo") Integer boardNo){
        log.info("boardRead()" + boardNo);

        return boardService.read(boardNo);
    }

    @GetMapping("/read/img/{boardNo}")
    public List<BoardImgResponse> boardReadImg( @PathVariable("boardNo") Integer boardNo){

        log.info("boardReadImg()");
        //List<BoardImgResponse> boardImgList = boardService.imgList(boardNo);

        return boardService.imgList(boardNo);
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove(@PathVariable Integer boardNo){
        log.info("boardRemove()" + boardNo);

        boardService.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board boardModify(@PathVariable Integer boardNo, @RequestBody Board board){
        log.info("boardModify() "+boardNo +", board :" + board.getTitle() + ", " + board.getPlace() + ", "+board.getBoardContent());
        board.setBoardNo(boardNo);
        boardService.modify(board);

        return board;
    }

    @PostMapping("/img/{boardNo}")
    public Board boardImgModify(@PathVariable Integer boardNo, @RequestParam("boardNo") List<String> boardImgNo){
        log.info("boardImgModify() "+boardNo +", board :" + boardImgNo.size() + ", "+Integer.valueOf(boardImgNo.get(0)));

        boardService.modifyImg(boardNo, boardImgNo);

        return null;
    }

    @PostMapping("/search")
    public List<Board> boardSearchList(@RequestBody HashMap<String, String> searchBoard){
        log.info("boardSearchList() " + searchBoard.get("searchBoard"));

        return boardService.searchPlace(searchBoard.get("searchBoard"));
    }

    @PostMapping("/comment")
    public void boardComment(@RequestBody BoardCommentRequest boardCommentRequest){
        log.info("boardComment() : "+ boardCommentRequest.getComment() + " , " + boardCommentRequest.getBoardNo() + ", " + boardCommentRequest.getWriter());

        boardService.saveComment(boardCommentRequest);
    }

    @GetMapping("/read/comment/{boardNo}")
    public List<BoardCommentResponse> boardCommentList(@PathVariable Integer boardNo){
        log.info("boardCommentList() " +  boardNo);

        return boardService.commentList(boardNo);
    }
}
