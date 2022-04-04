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
    public String uploadCakeDetail (@Validated @RequestBody UploadRequest uploadRequest,
                                  @RequestParam("fileList") List<MultipartFile> fileList) {
        log.info("uploadCakeDetail()");
        log.info("uploadImgFamily(): " + fileList );

        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());



                FileOutputStream writer = new FileOutputStream(
                        "../../vue_frontend/book_cake/src/assets/uploadImg/family/" +multipartFile.getOriginalFilename());
                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
                service.register(uploadRequest, multipartFile.getOriginalFilename());
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";


    }
//
//    @ResponseBody
//    @PostMapping("/uploadImgFamily")
//    public String requestUploadFile (
//            @RequestParam("fileList") List<MultipartFile> fileList) {
//
//        log.info("uploadImgFamily(): " + fileList );
//
//
//        try {
//            for (MultipartFile multipartFile : fileList) {
//                log.info("requestUploadFile() - Make file: " +
//                        multipartFile.getOriginalFilename());
//
//
//
//                    FileOutputStream writer = new FileOutputStream(
//                            "../../vue_frontend/book_cake/src/assets/uploadImg/family/" +multipartFile.getOriginalFilename());
//                    log.info("디렉토리에 파일 배치 성공!");
//
//                    writer.write(multipartFile.getBytes());
//                    writer.close();
//                    service.familyImg(multipartFile.getOriginalFilename());
//            }
//        } catch (Exception e) {
//            return "Upload Fail!!!";
//        }
//
//        log.info("requestUploadFile(): Success!!!");
//
//        return "Upload Success!!!";
//
//    }
//
//    @ResponseBody
//    @PostMapping("/uploadImgFriend")
//    public String uploadImgFriend (
//            @RequestParam("fileList") List<MultipartFile> fileList) {
//
//        log.info("uploadImgFriend(): " + fileList );
//
//
//        try {
//            for (MultipartFile multipartFile : fileList) {
//                log.info("requestUploadFile() - Make file: " +
//                        multipartFile.getOriginalFilename());
//
//                FileOutputStream writer = new FileOutputStream(
//                        "../../vue_frontend/book_cake/src/assets/uploadImg/friend/" +multipartFile.getOriginalFilename());
//                log.info("디렉토리에 파일 배치 성공!");
//
//                writer.write(multipartFile.getBytes());
//                writer.close();
//                service.friendImg(multipartFile.getOriginalFilename());
//            }
//        } catch (Exception e) {
//            return "Upload Fail!!!";
//        }
//
//        log.info("requestUploadFile(): Success!!!");
//
//        return "Upload Success!!!";
//
//    }
//    @ResponseBody
//    @PostMapping("/uploadImgLover")
//    public String uploadImgLover (
//            @RequestParam("fileList") List<MultipartFile> fileList) {
//
//        log.info("uploadImgLover(): " + fileList );
//
//
//        try {
//            for (MultipartFile multipartFile : fileList) {
//                log.info("requestUploadFile() - Make file: " +
//                        multipartFile.getOriginalFilename());
//
//                FileOutputStream writer = new FileOutputStream(
//                        "../../vue_frontend/book_cake/src/assets/uploadImg/lover/" +multipartFile.getOriginalFilename());
//                log.info("디렉토리에 파일 배치 성공!");
//
//                writer.write(multipartFile.getBytes());
//                writer.close();
//                service.loverImg(multipartFile.getOriginalFilename());
//            }
//        } catch (Exception e) {
//            return "Upload Fail!!!";
//        }
//
//        log.info("requestUploadFile(): Success!!!");
//
//        return "Upload Success!!!";
//
//    }
//    @ResponseBody
//    @PostMapping("/uploadImgBirthday")
//    public String uploadImgBirthday (
//            @RequestParam("fileList") List<MultipartFile> fileList) {
//
//        log.info("uploadImgBirthday(): " + fileList );
//
//
//        try {
//            for (MultipartFile multipartFile : fileList) {
//                log.info("requestUploadFile() - Make file: " +
//                        multipartFile.getOriginalFilename());
//
//                FileOutputStream writer = new FileOutputStream(
//                        "../../vue_frontend/book_cake/src/assets/uploadImg/birthday/" +multipartFile.getOriginalFilename());
//                log.info("디렉토리에 파일 배치 성공!");
//
//                writer.write(multipartFile.getBytes());
//                writer.close();
//                service.birthdayImg(multipartFile.getOriginalFilename());
//            }
//        } catch (Exception e) {
//            return "Upload Fail!!!";
//        }
//
//        log.info("requestUploadFile(): Success!!!");
//
//        return "Upload Success!!!";
//
//    }

}
