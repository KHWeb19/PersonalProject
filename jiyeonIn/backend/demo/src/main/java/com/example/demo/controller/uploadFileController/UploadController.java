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
    private int couontFa = 0;
    private int countB = 0;
    private int couontL = 0;
    private int countFr = 0;

    @Autowired
    UploadCakeService service;

    @PostMapping("/register")
    public void uploadCakeDetail (@Validated @RequestBody UploadRequest uploadRequest) {
        log.info("uploadCakeDetail()");

        service.register(uploadRequest);
    }

    @ResponseBody
    @PostMapping("/uploadImgFamily")
    public String requestUploadFile (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("uploadImgFamily(): " + fileList );

        couontFa++;
        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());


                int count=1;
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/family/" + couontFa +"."+multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";

    }

    @ResponseBody
    @PostMapping("/uploadImgFriend")
    public String uploadImgFriend (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("uploadImgFriend(): " + fileList );

        countFr++;
        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                        "../../vue_frontend/book_cake/src/assets/uploadImg/friend/" + countFr +"."+multipartFile.getOriginalFilename());
                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";

    }
    @ResponseBody
    @PostMapping("/uploadImgLover")
    public String uploadImgLover (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("uploadImgLover(): " + fileList );

        couontL++;
        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                        "../../vue_frontend/book_cake/src/assets/uploadImg/lover/" + couontL +"."+multipartFile.getOriginalFilename());
                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";

    }
    @ResponseBody
    @PostMapping("/uploadImgBirthday")
    public String uploadImgBirthday (
            @RequestParam("fileList") List<MultipartFile> fileList) {

        log.info("uploadImgBirthday(): " + fileList );

        countB++;
        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                        "../../vue_frontend/book_cake/src/assets/uploadImg/birthday/" + countB +"."+multipartFile.getOriginalFilename());
                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";

    }

}
