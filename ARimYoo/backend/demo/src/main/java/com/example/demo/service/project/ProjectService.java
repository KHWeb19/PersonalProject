package com.example.demo.service.project;

import com.example.demo.entity.project.Project;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ProjectService {

    public void register (Project project, @RequestParam(required = false) MultipartFile file) throws Exception;
}
