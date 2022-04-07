package com.example.demo.controller.uploadFileController;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.upload.UploadRepository;
import com.example.demo.service.uploadCakeImpl.UploadCakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @ResponseBody
    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String uploadCakeDetail ( @RequestPart(value = "fileList") List<MultipartFile> fileList,
                                     @RequestPart(value = "info") UploadRequest info
                                  ) {
        log.info("uploadCakeDetail()" + info);
        log.info("uploadImg(): " + fileList );


        try {
            for (MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                if(info.getDesign().equals("family")) {
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/family/" +multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.register(info, multipartFile.getOriginalFilename());
                }else if (info.getDesign().equals("birthday")) {
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/birthday/" +multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.register(info, multipartFile.getOriginalFilename());
                }else if (info.getDesign().equals("friend")) {
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/friend/" +multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.register(info, multipartFile.getOriginalFilename());
                }else if (info.getDesign().equals("lover")) {
                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/uploadImg/lover/" +multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.register(info, multipartFile.getOriginalFilename());
                }
            }
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }

    @GetMapping("/list")
    public List<UploadCake> uploadCakes() {
        log.info("uploadCakeList()");

        return service.list();
    }
}
