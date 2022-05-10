package com.example.backend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmazonS3Service {

    @Value("${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 amazonS3Client;

    public String uploadFile(MultipartFile file, String strUUID) {

        File convertedFile = convertMultiToFile(file);
        String fileName = strUUID  + '_' + file.getOriginalFilename();
        log.info("filename: {}", fileName);
        amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, convertedFile));
        if (convertedFile.delete()){
            log.info("File Deleted");
        }
        else{
            log.info("File not deleted");
        }
        return amazonS3Client.getUrl(bucketName, fileName).toString();

    }

    public String deleteFile(String fileName){
        amazonS3Client.deleteObject(bucketName, fileName);
        return "Successfully Removed File: " + fileName;
    }

    private File convertMultiToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());

        try(FileOutputStream outputStream = new FileOutputStream(convertedFile)){
            outputStream.write(file.getBytes());
        }
        catch(IOException e){
            log.error("Converting Multi to file error: ", e);
        }

        return convertedFile;

    }
}
