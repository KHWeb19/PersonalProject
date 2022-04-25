package com.example.demo.controller.project;

import com.example.demo.entity.project.Project;
import com.example.demo.service.project.ProjectService;
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
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/register")
    public void ProjectRegister (@Validated Project project, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("ProjectRegister();" + file);
        service.register(project, file);

    }
}
