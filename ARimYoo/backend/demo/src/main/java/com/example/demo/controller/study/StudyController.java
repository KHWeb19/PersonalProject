package com.example.demo.controller.study;

import com.example.demo.entity.study.Study;
import com.example.demo.service.study.StudyService;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/study")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class StudyController {

    @Autowired
    private StudyService service;

    @GetMapping("/list/{memberNo}")
    public List<Study> study (@PathVariable("memberNo") Long memberNo) {
        log.info("member study list" + memberNo);
        return service.list(memberNo);
    }

    @PostMapping("join/{memberNo}")
    public boolean join (@PathVariable("memberNo") Long memberNo, @RequestBody Study study) {
        log.info("join study !" + memberNo);
        return service.join(memberNo, study);
    }

    @GetMapping("/{studyNo}")
    public Study read (@PathVariable("studyNo") Long studyNo) {
        log.info("read()");
        return service.read(studyNo);
    }
}
