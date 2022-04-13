package com.example.demo.controller.reviewController;

import com.example.demo.controller.reviewController.request.ReviewRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.service.review.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ReviewController {

    @Autowired
    ReviewService service;

    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String reviewRegister(@RequestPart(value = "info", required = false) ReviewRequest info,
                                 @RequestPart(value = "fileList",required = false) List<MultipartFile> fileList) {

        log.info("review info: " + info);
        log.info("fileList: " +fileList);

        if(fileList != null) {
            try {
                for(MultipartFile multipartFile: fileList){
                    log.info("requestUploadFile() - Make file: " +
                            multipartFile.getOriginalFilename());

                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/review/" +info.getId() +"."+ multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.includeImgReview(info, multipartFile.getOriginalFilename());
                }

            } catch (Exception e) {
                return "review fail!";
            }
        }else if(fileList == null) {
            service.exceptImgReview(info);
        }

        log.info("requestUpload(): Success!!!");
        return "Upload Success!!";
    }

    @GetMapping("/list")
    public List<Review> reviewList() {
        return service.list();
    }
}
