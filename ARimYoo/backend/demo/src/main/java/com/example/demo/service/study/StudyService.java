package com.example.demo.service.study;

import com.example.demo.entity.study.Study;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudyService {

    public List<Study> list (Long memberNo);
}
