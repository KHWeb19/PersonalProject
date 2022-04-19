package com.example.demo.controller.review;

import com.example.demo.controller.Request.keywordRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.repository.review.ReviewRepository;
import com.example.demo.service.review.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/board/review")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReviewController {
    @Autowired
    private ReviewService service;
    @Autowired
    private ReviewRepository repository;

    @PostMapping("/register")
    public void ReviewRegister (@Validated Review review, @RequestParam(required = false) List<MultipartFile> file) throws Exception {
        log.info ("ReviewRegister();" + file);
        service.register(review, file);

    }

    @GetMapping("/list")
    public List<Review> reviewList () {
        log.info("ReviewList");

        return service.list ();
    }

    @GetMapping("/{reviewNo}")
    public Review read (
            @PathVariable("reviewNo") Long reviewNo) {
        log.info("read()");
        return service.read(reviewNo);
    }

    @PutMapping("/{reviewNo}")
    public Review modify (
            @PathVariable("reviewNo") Integer reviewNo,
            Review review, @RequestParam(required = false) List<MultipartFile> file) throws Exception  {

        Optional<Review> getFileName = repository.findById(Long.valueOf(reviewNo));
        Review getFile = getFileName.get();


        if (getFile.getFileName1() != null ) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName1());
            Files.delete(filePath);
        }
        if (getFile.getFileName2() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName2());
            Files.delete(filePath);
        }
        if (getFile.getFileName3() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName3());
            Files.delete(filePath);
        }
        if (getFile.getFileName4() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName4());
            Files.delete(filePath);
        }
        if (getFile.getFileName5() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + getFile.getFileName5());
            Files.delete(filePath);
        }

        log.info("modify(): " + review);
        review.setReviewNo(Long.valueOf(reviewNo));
        service.modify(review, file);

        return review;
    }

    @DeleteMapping("/{reviewNo}")
    public void remove(
            @PathVariable("reviewNo") Integer reviewNo, Review review) throws Exception  {
        log.info("remove()");

        Optional<Review> selectFile = repository.findById(Long.valueOf(reviewNo));
        Review deleteFile = selectFile.get();

        if (deleteFile.getFileName1() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName1());
            Files.delete(filePath);
        }

        if (deleteFile.getFileName2() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName2());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName3() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName3());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName4() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName4());
            Files.delete(filePath);
        }
        if (deleteFile.getFileName5() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\review\\" + deleteFile.getFileName5());
            Files.delete(filePath);
        }

        service.remove(reviewNo);

    }

    @PostMapping("/search")
    public List<Review> searchList (@RequestBody keywordRequest keyword) {
        log.info("searchList! " + keyword);
        String key = keyword.getKeyword();
        return service.searchList(key);
    }


}
