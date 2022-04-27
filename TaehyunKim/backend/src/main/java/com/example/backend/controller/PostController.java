package com.example.backend.controller;


import com.example.backend.entity.Post;
import com.example.backend.service.PostService;
import com.example.backend.service.UserService;
import com.example.backend.util.AttachmentUtility;
import com.example.backend.util.OriginalFiles;
import com.example.backend.util.PostUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/freepost")
public class PostController {

    private final PostService postService;
    private final UserService userService;


    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createPost(@RequestPart(value="fileList", required = false) List<MultipartFile> fileList,
                                        @RequestPart(value="info") Post post, Principal principal){

        log.info("Creating Post");

        AttachmentUtility attachmentUtility = new AttachmentUtility();
        PostUtility postUtility = new PostUtility(userService);

        try {
            Post attachPost = attachmentUtility.createAttachment(fileList, post);

            Post authorPost = postUtility.settingAuthor(attachPost, principal);


            postService.createPost(authorPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> listPosts(){
        log.info("LISTING POSTS");

        return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{no}")
    public ResponseEntity<Post> getPost(@PathVariable int no){
        log.info("Reading Post #{}", no);

        return new ResponseEntity<Post>(postService.readPost(no), HttpStatus.OK);
    }

    @GetMapping("/validate/{no}")
    public ResponseEntity<Boolean> validateUser(@PathVariable(value="no") int no, Principal principal){
        log.info("Validating a user");

        Boolean result;

        String author = postService.readPost(no).getAuthor();

        String user = principal.getName();

        // 로그인유저 vs Post 작성자 검사
        if (postService.readPost(no).getAuthor().equals(principal.getName())){
            log.info("Author Validated");
            result = true;
        }
        else{
            result = false;
        }

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/modify/{no}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> modifyPost(@PathVariable(value="no") int no,
                                        @RequestPart(value = "fileList", required = false) List<MultipartFile> multipartFile,
                                        @RequestPart("post") Post post,
                                        Principal principal){

        log.info("Modifying Post #{}",no);

        AttachmentUtility attachmentUtility = new AttachmentUtility();
        PostUtility postUtility = new PostUtility(userService);

        try {
            Post attachPost = attachmentUtility.createAttachment(multipartFile, post);

            Post authorPost = postUtility.settingAuthor(attachPost, principal);


            postService.modifyPost(authorPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return ResponseEntity.ok().build();
    }
}
