package com.example.demo.controller.bookingController;

import com.example.demo.controller.bookingController.request.BookingRequest;
import com.example.demo.service.booking.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BookingController {

    @Autowired
    BookingService service;

    @ResponseBody
    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String uploadBookingContents ( @RequestPart(value = "info") BookingRequest info,
                                          @RequestPart(value = "fileList", required = false) List<MultipartFile> fileList) {

        log.info("uploadBookingContents()" + info);
        log.info("uploadImg()" + fileList);

        try{
            for(MultipartFile multipartFile : fileList) {
                log.info("requestUploadFile() - Make file: " +
                        multipartFile.getOriginalFilename());

                FileOutputStream writer = new FileOutputStream(
                        "../../vue_frontend/book_cake/src/assets/bookingImg/"+info.getDate()+"/"+info.getId()+"/"+multipartFile.getOriginalFilename());
                log.info("디렉토리에 파일 배치 성공!");

                writer.write(multipartFile.getBytes());
                writer.close();
                service.register(info, multipartFile.getOriginalFilename());
            }
        } catch (Exception e) {
            return "Upload Fail!!";
        }

        log.info("requestUpload(): Success!!!");
        return "Upload Success!!";
    }
}