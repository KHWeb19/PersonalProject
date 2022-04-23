package com.example.demo.controller.study;

import com.example.demo.entity.communityBoard.CommunityBoard;
import com.example.demo.entity.study.Study;
import com.example.demo.entity.study.StudyBoard;
import com.example.demo.service.study.StudyBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/study")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class StudyBoardController {

    @Autowired
    private StudyBoardService service;


    @PostMapping("/register")
    public void StudyRegister (@Validated StudyBoard study, Study studyGroup, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("StudyRegister();" + file);
        service.register(study, studyGroup, file);
    }

    @GetMapping("/list")
    public List<StudyBoard> studyList () {
        log.info("studyList");
        return service.list();
    }

    @GetMapping("/{studyNo}")
    public StudyBoard read (
            @PathVariable("studyNo") Long studyNo) {
        log.info("read()");
        return service.read(studyNo);
    }

    @PutMapping("/{studyNo}")
    public StudyBoard modify (@PathVariable("studyNo") Integer studyNo,
            StudyBoard studyBoard) throws Exception  {
        log.info("modify(): " + studyBoard);

        studyBoard.setStudyNo(Long.valueOf(studyNo));
        service.modify(studyBoard);

        return studyBoard;
    }

    @DeleteMapping("/{studyNo}")
    public void remove(
            @PathVariable("studyNo") Integer studyNo, StudyBoard studyBoard) throws Exception  {
        log.info("remove()");
        service.remove(studyNo);

    }

}
