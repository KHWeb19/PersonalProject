package com.example.demo.controller.comments;



import com.example.demo.controller.comments.request.CommentsRequest;
import com.example.demo.entitiy.comments.Comments;
import com.example.demo.service.comments.CommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CommentsController {

    @Autowired
    private CommentsService service;

    @PostMapping("/register")
    public void CommentsRegister (@Validated @RequestBody CommentsRequest commentsRequest) {
        log.info("FreeBoardRegister()");

        service.register(commentsRequest);


    }
}
