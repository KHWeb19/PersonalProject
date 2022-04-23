package com.example.demo.controller.personalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.service.presonalProject.NoticeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class NoticeBoardController {

    @Autowired
    private NoticeBoardService noticeService;

    @PostMapping("/register")
    public void noticeBoardRegister (@Validated @RequestBody NoticeBoard noticeBoard) {
        log.info("noticeBoardRegister()");

        noticeService.register(noticeBoard);
    }

    @GetMapping("/list")
    public List<NoticeBoard> noticeBoardList() {
        log.info("noticeBoardList()");

        return noticeService.list();
    }

    @GetMapping("/{boardNo}")
    public NoticeBoard noticeBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("noticeBoardRead");

        return noticeService.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public NoticeBoard noticeBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody NoticeBoard noticeBoard) {
        log.info ("noticeBoardModify(): " + noticeBoard);

        noticeBoard.setBoardNo((Long.valueOf(boardNo)));
        noticeService.modify(noticeBoard);

        return noticeBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void noticeBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("noticeBoardRemove()");

        noticeService.remove(boardNo);
    }

}
