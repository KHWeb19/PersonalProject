package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fileUpload")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @PostMapping("/BrandCheckBoard")
    @ResponseBody
    public String checkBrandFileUpload(@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList,
                                       @RequestParam("boardNo") Long boardNo){
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/BrandCheck/" + boardNo + "_" + ".jpg");
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Recommend File Upload Fail";
        }
        return "Recommend File Upload Success";
    }
  /*  public String checkBrandFileUpload(@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList,
                                       @RequestParam("boardNo") Long boardNo, @RequestParam("id") String id) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/BrandCheck/" + boardNo + "_" + id + ".jpg");
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Recommend File Upload Fail";
        }
        return "Recommend File Upload Success";
    }*/

    @PostMapping("/QuestionBoard")
    @ResponseBody
    public String QuestionFileUpload(@RequestParam(value = "fileList", required = false) List<MultipartFile> fileList,
                                     @RequestParam("boardNo") Long boardNo, @RequestParam("id") String id) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/Question/" + boardNo + "_" + id + ".jpg");
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "Recommend File Upload Fail";
        }
        return "Recommend File Upload Success";
    }
}