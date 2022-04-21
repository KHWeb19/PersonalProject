package com.example.demo.service.study;

import com.example.demo.entity.study.Study;
import com.example.demo.entity.study.StudyBoard;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface StudyService {

    public void register (Study study, @RequestParam(required = false) MultipartFile file) throws Exception;
}
