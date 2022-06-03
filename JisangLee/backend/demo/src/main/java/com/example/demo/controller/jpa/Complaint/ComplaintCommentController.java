package com.example.demo.controller.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintComment;
import com.example.demo.entity.jpa.Local.LocalComment;
import com.example.demo.service.jpa.Complaint.ComplaintCommentService;
import com.example.demo.service.jpa.Local.LocalCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/complaintboard")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")

public class ComplaintCommentController {
    @Autowired
    private ComplaintCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated ComplaintComment complaintComment, @PathVariable ("boardNo") Integer boardNo){
        log.info("register" + complaintComment);
        service.register(boardNo, complaintComment);
    }

    @GetMapping("/{boardNo}/comment/list")
    public List<ComplaintComment> read (@PathVariable("boardNo") Integer boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , ComplaintComment complaintComment){
        log.info("Comment remove()");
        service.delete(commentId);
    }
}
