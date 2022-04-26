package com.example.demo.controller.board.videoBoard;

import com.example.demo.dto.request.BoardRequest;
import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.LikeRequest;
import com.example.demo.dto.response.BoardResponse;
import com.example.demo.service.board.BaseBoardService;
import com.example.demo.service.board.videoBoard.VideoBoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/videoBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VideoBoardController {

    @Autowired
    private BaseBoardService videoBoardServiceImpl;

    //등록
    @PostMapping(value = "/register",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void VideoBoardRegister ( @RequestPart(value="board") BoardRequest board,
                                     @RequestPart(value="files") MultipartFile files) throws Exception {
        log.info("VideoBoardRegister()" + board + "file" + files);

        videoBoardServiceImpl.register(board, files);
    }
    //목록
    @PostMapping("/list")
    public Object VideoBoardList (@RequestBody CommentRequest commentRequest) {
        log.info("VideoBoardList()");

        String writer = commentRequest.getWriter();

        videoBoardServiceImpl.likeCheck(writer);

        return videoBoardServiceImpl.list();
    }
    //읽기
    @GetMapping("/{boardNo}")
    public Object VideoBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("videoBoardRead()");

        return videoBoardServiceImpl.read(boardNo);
    }
    //파일 업로드

    //수정
    @PutMapping(value = "/{boardNo}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public BoardRequest VideoBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestPart(value="board") BoardRequest board,
            @RequestPart(value="files", required = false) MultipartFile files) throws Exception {
        log.info("videoBoardModify(): " + board + "boardNo" + boardNo);

        board.setBoardNo(Long.valueOf(boardNo));
        videoBoardServiceImpl.modify(boardNo, board, files);

        return board;
    }

    @DeleteMapping("/{boardNo}")
    public void VideoBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("videoBoardRemove()");

        videoBoardServiceImpl.remove(boardNo);
    }

    @PostMapping("/like")
    public void VideoBoardLike(@RequestBody LikeRequest like){
        log.info("xxlikeRequest" + like);

        videoBoardServiceImpl.doLike(like);

    }

    @PostMapping("/unlike")
    public void VideoBoardUnlike(@RequestBody LikeRequest like){
        // like에 boardNo의 writer이 같으면 삭제 해야되는데 이건 그럼 id값으로 삭제해야되나??
        //id값을 어디서 구해야하오?? 두개 같으면 쿼리문이 되나??ㅋㅋㅋ
        //만약에 writer로 보드값 쫙 가져왔는데 거기서 boardNo 가져 온거랑 똑같으면 삭제 하도록??
        // 아이다 아이디가 있어야 삭제를 하지
        log.info("liek" + like);
        videoBoardServiceImpl.unDoLike(like);
    }

}
