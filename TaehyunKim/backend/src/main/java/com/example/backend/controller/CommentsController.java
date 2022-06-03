package com.example.backend.controller;

import com.example.backend.entity.Comments;
import com.example.backend.entity.Post;
import com.example.backend.service.CommentsService;
import com.example.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsService commentsService;
    private final PostService postService;

    @PostMapping("/create/{no}")
    public ResponseEntity<?> createComments(@PathVariable("no") int no, Principal principal, @RequestBody Comments currentComments){
        log.info("Creating Comments on {}", no);

        currentComments.setAuthor(principal.getName());
        currentComments.setRegdate(LocalDateTime.now());

        log.info("Comments: {}", currentComments);

        Post post = postService.readPost(no);
        commentsService.createComment(currentComments, post);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Comments>> listComments(@RequestParam("no") int no,
            @PageableDefault(page = 0, size= 10, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        log.info("Comments pagination...");

        Post post = postService.readPost(no);
        Page<Comments> comments = commentsService.listComments(post, pageable);
        log.info(String.valueOf(comments));

        return new ResponseEntity<Page<Comments>>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComments(@RequestParam("no") int no){
        log.info("Deleting comments {}", no);

        commentsService.deleteComments(no);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate/{no}")
    public ResponseEntity<Boolean> validateUser(@PathVariable(value="no") int no, Principal principal){
        log.info("Validating a user");

        Boolean result;

        String author = commentsService.readComment(no).get().getAuthor();

        String user = principal.getName();

        // 로그인유저 vs Post 작성자 검사
        if (author.equals(user)){
            log.info("Author Validated");
            result = true;
        }
        else{
            result = false;
        }

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
}
