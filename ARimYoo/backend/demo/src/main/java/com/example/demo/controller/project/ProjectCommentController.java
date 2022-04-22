package com.example.demo.controller.project;

import com.example.demo.entity.project.ProjectComment;
import com.example.demo.service.project.ProjectCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/project")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ProjectCommentController {

    @Autowired
    private ProjectCommentService service;

    @PostMapping("/{projectNo}/comment/register")
    public void register (@Validated ProjectComment projectComment, @PathVariable ("projectNo") Long projectNo
                          ){
        log.info("register" + projectComment);
        service.register(projectNo, projectComment);

    }

    @GetMapping("/{projectNo}/comment/list")
    public List<ProjectComment> read (@PathVariable("projectNo") Long projectNo){
        log.info("comment List");
        return service.list(projectNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , ProjectComment projectComment) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
