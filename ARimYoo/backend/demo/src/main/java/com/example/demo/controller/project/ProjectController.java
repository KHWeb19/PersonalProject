package com.example.demo.controller.project;

import com.example.demo.entity.project.Project;
import com.example.demo.entity.study.Study;
import com.example.demo.service.project.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/project")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/list/{memberNo}")
    public List<Project> project (@PathVariable("memberNo") Long memberNo) {
        log.info("member project list" + memberNo);
        return service.list(memberNo);
    }

    @PostMapping("/join/{memberNo}")
    public boolean join (@PathVariable("memberNo") Long memberNo, @RequestBody Project project) {
        log.info("join study !" + memberNo);
        return service.join(memberNo, project);
    }

    @GetMapping("/{projectNo}")
    public Project read (@PathVariable("projectNo") Long projectNo) {
        log.info("read()");
        return service.read(projectNo);
    }

    // toDo설정

    @PutMapping("/{projectNo}/toDo")
    public Project toDoRegister (@PathVariable("projectNo") Long projectNo, @RequestBody Project project) {
        log.info("register=====" + projectNo);

        project.setProjectNo(Long.valueOf(projectNo));
        service.toDoRegister(project);
        return project;
    }
}
