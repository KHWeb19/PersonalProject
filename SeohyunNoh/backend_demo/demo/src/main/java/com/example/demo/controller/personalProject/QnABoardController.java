package com.example.demo.controller.personalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;
import com.example.demo.service.presonalProject.QnAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public QnABoard noticeBoardModify (
            @PathVariable("qnaNo") Integer qnaNo,
            @RequestBody QnABoard qnABoard) {
        log.info ("noticeBoardModify(): " + qnABoard);

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
}
