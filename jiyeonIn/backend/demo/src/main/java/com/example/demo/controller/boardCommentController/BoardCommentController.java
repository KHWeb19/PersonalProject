package com.example.demo.controller.boardCommentController;

import com.example.demo.controller.boardCommentController.request.BoardCommentRequest;
import com.example.demo.entity.boardComment.BoardComment;
import com.example.demo.service.boardComment.BoardCommentService;
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
@RequestMapping("/boardComment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardCommentController {

    @Autowired
    BoardCommentService service;

    @PostMapping(value = "/register/{bookingNo}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String boardCommentRegister (@PathVariable ("bookingNo") Integer bookingNo,
                                        @RequestPart(value = "info", required = true) BoardCommentRequest info,
                                        @RequestPart(value = "fileList", required = false) List<MultipartFile> fileList) throws FileNotFoundException {
        log.info("boardCommentRegister : " + info);
        log.info("fileList: " + fileList);

        info.setBookingNo(Long.valueOf(bookingNo));

        if(fileList != null) {
            try{
                for(MultipartFile multipartFile : fileList){
                    log.info("requestUploadFile() - Make file: " +
                            multipartFile.getOriginalFilename());

                    FileOutputStream writer = new FileOutputStream(
                            "../../vue_frontend/book_cake/src/assets/boardComment/"+bookingNo+"."+info.getId()+"."+multipartFile.getOriginalFilename());
                    log.info("디렉토리에 파일 배치 성공!");

                    writer.write(multipartFile.getBytes());
                    writer.close();
                    service.includeCommentRegister(info, multipartFile.getOriginalFilename());
                }
            }catch (Exception e) {
                return "comment fail!";
            }
        }else if(fileList == null) {
            service.exceptFileCommentRegister(info);
        }
        log.info("requestUpload(): Success!!!");
        return "Upload Success!!";
    }

    @GetMapping("/list")
    public List<BoardComment> boardCommentList() {
        log.info("boardCommentList()");

        return service.list();
    }


}
