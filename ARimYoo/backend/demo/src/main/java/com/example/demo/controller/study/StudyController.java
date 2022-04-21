package com.example.demo.controller.study;

import com.example.demo.entity.study.Study;
import com.example.demo.service.study.StudyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService service;

    @PostMapping("/register")
    public void StudyRegister (@Validated Study study, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("StudyRegister();" + file);
        service.register(study, file);

    }
}
