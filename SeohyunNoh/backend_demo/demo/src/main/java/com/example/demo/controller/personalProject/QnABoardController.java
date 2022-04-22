package com.example.demo.controller.personalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;
import com.example.demo.service.personalProject.QnAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class QnABoardController {

    @Autowired
    private QnAService qnaService;

    @PostMapping("/register")
    public void qnaBoardRegister (@Validated @RequestBody QnABoard qnABoard) {
        log.info("qnaBoardRegister()");

        qnaService.register(qnABoard);
    }

    @GetMapping("/list")
    public List<QnABoard> qnABoardList() {
        log.info("qnABoardList()");

        return qnaService.list();
    }

    @GetMapping("/{qnaNo}")
    public QnABoard qnABoardRead (
            @PathVariable("qnaNo") Integer qnaNo) {
        log.info("qnABoardRead");

        return qnaService.read(qnaNo);
    }

    @PutMapping("/{qnaNo}")
    public QnABoard qnaBoardModify (
            @PathVariable("qnaNo") Integer qnaNo,
            @RequestBody QnABoard qnABoard) {
        log.info ("qnaBoardModify(): " + qnABoard);

        qnABoard.setQnaNo((Long.valueOf(qnaNo)));
        qnaService.modify(qnABoard);

        return qnABoard;
    }

    @DeleteMapping("/{qnaNo}")
    public void qnaBoardRemove (
            @PathVariable("qnaNo") Integer qnaNo) {
        log.info("qnaBoardRemove()");

        qnaService.remove(qnaNo);
    }

    @GetMapping("/userRead/{id}")
    public ResponseEntity userRead(@PathVariable("id") String id) throws Exception {
        log.info("QnA UserRead");

        List<QnABoard> qnABoards = qnaService.userRead(id);

        return new ResponseEntity(qnABoards, HttpStatus.OK);
    }

}
