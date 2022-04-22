package com.example.demo.controller.study;

import com.example.demo.entity.study.StudyComment;
import com.example.demo.service.study.StudyCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/study")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class StudyCommentController {

    @Autowired
    private StudyCommentService service;

    @PostMapping("/{studyNo}/comment/register")
    public void register (@Validated StudyComment studyComment, @PathVariable ("studyNo") Long studyNo
                          ){
        log.info("register" + studyComment);
        service.register(studyNo, studyComment);

    }

    @GetMapping("/{studyNo}/comment/list")
    public List<StudyComment> read (@PathVariable("studyNo") Long studyNo){
        log.info("comment List");
        return service.list(studyNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , StudyComment studyComment) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
