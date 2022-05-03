package com.example.backend.controller;


import com.example.backend.entity.Post;
import com.example.backend.service.AmazonS3Service;
import com.example.backend.service.PostService;
import com.example.backend.service.UserService;
import com.example.backend.util.AttachmentUtility;
import com.example.backend.util.OriginalFiles;
import com.example.backend.util.PostUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private final AmazonS3Service amazonS3Service;

    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createPost(@RequestPart(value="fileList", required = false) List<MultipartFile> fileList,
                                        @RequestPart(value="post") Post post,Principal principal
                                        ,@RequestPart(value="strUUID") String strUUID){
        log.info("Creating Post");

        log.info("UUID: {}", strUUID);

        AttachmentUtility attachmentUtility = new AttachmentUtility(amazonS3Service);
        PostUtility postUtility = new PostUtility(userService);

        try {
            Post attachPost = attachmentUtility.createAttachment(fileList, post, strUUID);

            Post authorPost = postUtility.settingAuthor(attachPost, principal);


            postService.createPost(authorPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Post>> listPosts(@PageableDefault(page = 0, size= 10, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        log.info("LISTING POSTS");

        log.info("SIZE: {}", pageable.getPageSize());
        log.info("PAGE: {}", pageable.getPageNumber());

        Page<Post> posts = postService.getPosts(pageable);

        return new ResponseEntity<Page<Post>>(postService.getPosts(pageable), HttpStatus.OK);
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
                                        Principal principal,
                                        String strUUID){

        log.info("Modifying Post #{}",no);

        AttachmentUtility attachmentUtility = new AttachmentUtility(amazonS3Service);
        PostUtility postUtility = new PostUtility(userService);

        try {
            Post postAttachmentsRemoved = attachmentUtility.deleteAttachment(post);

            Post attachPost = attachmentUtility.createAttachment(multipartFile, postAttachmentsRemoved, strUUID);

            Post authorPost = postUtility.settingAuthor(attachPost, principal);

            postService.createPost(authorPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }
    @DeleteMapping("delete/{no}")
    public ResponseEntity<?> deletePost(@PathVariable(value="no") int no){
        log.info("Delete request arrived");

        Post post = postService.readPost(no);
        AttachmentUtility attachmentUtility = new AttachmentUtility(amazonS3Service);
        attachmentUtility.deleteAllAttachments(post);

        postService.deletePost(no);
        return ResponseEntity.ok().build();
    }
}
