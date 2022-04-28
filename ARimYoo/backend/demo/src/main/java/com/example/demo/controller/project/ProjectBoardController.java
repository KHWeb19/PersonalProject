package com.example.demo.controller.project;

import com.example.demo.controller.Request.keywordRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.project.Project;
import com.example.demo.entity.project.ProjectBoard;
import com.example.demo.service.project.ProjectBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/project")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ProjectBoardController {

    @Autowired
    private ProjectBoardService service;


    @PostMapping("/register")
    public void ProjectRegister (@Validated ProjectBoard projectBoard, Project project, Member member, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info ("StudyRegister();" + file);
        service.register(projectBoard, project, member, file);
    }

    @GetMapping("/list")
    public List<ProjectBoard> projectList () {
        log.info("projectList");
        return service.list();
    }

    @GetMapping("/{projectNo}")
    public ProjectBoard read (
            @PathVariable("projectNo") Long projectNo) {
        log.info("read()");
        return service.read(projectNo);
    }

    @PutMapping("/{projectNo}")
    public ProjectBoard modify (@PathVariable("projectNo") Integer projectNo,
                                ProjectBoard projectBoard) throws Exception  {
        log.info("modify(): " + projectBoard);

        projectBoard.setProjectNo(Long.valueOf(projectNo));
        service.modify(projectBoard);

        return projectBoard;
    }

    @DeleteMapping("/{projectNo}")
    public void remove(
            @PathVariable("projectNo") Integer projectNo, ProjectBoard projectBoard) throws Exception  {
        log.info("remove()");
        service.remove(projectNo);

    }

    @PostMapping("/search")
    public List<ProjectBoard> searchList (@RequestBody keywordRequest keyword) {
        log.info("searchList! " + keyword);
        String key = keyword.getKeyword();
        return service.searchList(key);
    }

}
