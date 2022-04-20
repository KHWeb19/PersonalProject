package com.example.demo.controller.study;

import com.example.demo.entity.study.Study;
import com.example.demo.service.study.StudyService;
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
public class StudyController {

    @Autowired
    private StudyService service;

    @PostMapping("/register")
    public void StudyRegister (@Validated Study study, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("StudyRegister();" + file);
        service.register(study, file);

    }

    @GetMapping("/list")
    public List<Study> studyList () {
        log.info("studyList");
        return service.list();
    }

}
