package com.example.demo.controller.board.photoBoard;

import com.example.demo.dto.response.BoardResponse;
import com.example.demo.dto.request.BoardRequest;
import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.LikeRequest;
import com.example.demo.service.board.BaseBoardService;
import com.example.demo.service.board.photoBoard.PhotoBoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/photoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PhotoBoardController {

    @Autowired
    private BaseBoardService photoBoardServiceImpl;

    //등록
    @PostMapping(value = "/register",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void PhotoBoardRegister ( @RequestPart(value="board") BoardRequest board,
                                     @RequestPart(value="files") MultipartFile files) throws Exception {
        log.info("PhotoBoardRegister()" + board + "file" + files);

        photoBoardServiceImpl.register(board, files);
    }
    //목록
   @PostMapping("/list")
    public Object PhotoBoardList (@RequestBody CommentRequest commentRequest) {
        log.info("PhotoBoardList()" + commentRequest);

        String writer = commentRequest.getWriter();

       photoBoardServiceImpl.likeCheck(writer);

        return photoBoardServiceImpl.list();
    }
    //읽기
   @GetMapping("/{boardNo}")
    public Object photoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRead()");

        return photoBoardServiceImpl.read(boardNo);
    }

    //수정
    @PutMapping(value = "/{boardNo}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public BoardRequest photoBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestPart(value="board") BoardRequest board,
            @RequestPart(value="files", required = false) MultipartFile files) throws Exception {
        log.info("photoBoardModify(): " + board + "boardNo" + boardNo);

            board.setBoardNo(Long.valueOf(boardNo));
        photoBoardServiceImpl.modify(boardNo, board, files);

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void photoBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("photoBoardRemove()");

        //service.removeFile(boardNo);
        photoBoardServiceImpl.remove(boardNo);
    }

    @PostMapping("/like")
    public void photoBoardLike(@RequestBody LikeRequest like){
        log.info("xxlikeRequest" + like);

        photoBoardServiceImpl.doLike(like);

    }

    @PostMapping("/unlike")
    public void photoBoardUnlike(@RequestBody LikeRequest like){
    // like에 boardNo의 writer이 같으면 삭제 해야되는데 이건 그럼 id값으로 삭제해야되나??
    //id값을 어디서 구해야하오?? 두개 같으면 쿼리문이 되나??ㅋㅋㅋ
    //만약에 writer로 보드값 쫙 가져왔는데 거기서 boardNo 가져 온거랑 똑같으면 삭제 하도록??
    // 아이다 아이디가 있어야 삭제를 하지
        log.info("liek" + like);
        photoBoardServiceImpl.unDoLike(like);
    }
}
