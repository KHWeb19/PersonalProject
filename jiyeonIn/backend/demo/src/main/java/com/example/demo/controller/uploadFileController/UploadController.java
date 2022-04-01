package com.example.demo.controller.uploadFileController;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.upload.UploadRepository;
import com.example.demo.service.uploadCakeImpl.UploadCakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class UploadController {

    @Autowired
    UploadCakeService service;

    @PostMapping("/register")
    public void uploadCakeDetail (@Validated @RequestBody UploadRequest uploadRequest) {
        log.info("uploadCakeDetail()");

        service.register(uploadRequest);
    }

    @ResponseBody
    @PostMapping("/uploadImg/{design}")
    public String requestUploadFile (
            @RequestParam("fileList") List<MultipartFile> fileList,
            @PathVariable("design") String design ) {

        log.info("requestUploadFile(): " + fileList);

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                if(design.equals("family")){
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/famaily" + multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                }

            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";

    }
}
