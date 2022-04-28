package com.example.demo.Controller;

import com.example.demo.entity.BrandCheckComment;
import com.example.demo.request.BrandCheckCommentDto;
import com.example.demo.service.BrandCheckCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/BrandCheck/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BrandCheckCommentController {

    @Autowired
    private BrandCheckCommentService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody BrandCheckCommentDto brandcheckCommentDto) throws Exception {
        log.info("Comment Register");

        BrandCheckComment brandcheckComment = service.add(brandcheckCommentDto);

        return new ResponseEntity(brandcheckComment, HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable Long boardNo) throws Exception {
        log.info("Comment Read");

        List<BrandCheckComment> brandCheckComments = service.read(boardNo);

        return new ResponseEntity(brandCheckComments, HttpStatus.OK);
    }

    @GetMapping("/read/only/{commentNo}")
    public ResponseEntity readOnly(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Read Only");

        BrandCheckComment brandcheckComment =  service.readOnly(commentNo);

        return new ResponseEntity(brandcheckComment, HttpStatus.OK);
    }

    @PatchMapping("/modify/{commentNo}")
    public ResponseEntity<Void> modify(@PathVariable Long commentNo, @RequestBody BrandCheckCommentDto brandcheckCommentDto) throws Exception {
        log.info("Comment Modify");

        BrandCheckComment brandcheckComment = service.readOnly(commentNo);

        service.modify(brandcheckComment, brandcheckCommentDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable Long commentNo) throws Exception {
        log.info("Comment Remove");

        BrandCheckComment brandcheckComment = service.readOnly(commentNo);

        service.remove(brandcheckComment);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}


















