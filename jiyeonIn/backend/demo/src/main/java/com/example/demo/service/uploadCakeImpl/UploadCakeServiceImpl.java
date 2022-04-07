package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.upload.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class UploadCakeServiceImpl implements UploadCakeService{

    @Autowired
    UploadRepository uploadRepository;

    @Transactional
    @Override
    public void register(UploadRequest uploadRequest, String originalFilename) {

        //require('@/assets/uploadImg/birthday/1.birhday.png')
        String findLink = null;
        if(uploadRequest.getDesign().equals("birthday")) {
            findLink = "birthday/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("family")) {
            findLink = "family/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("friend")) {
            findLink = "friend/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("lover")) {
            findLink = "lover/" + originalFilename;
        }

        UploadCake uploadcake = new UploadCake(uploadRequest.getDesign(), uploadRequest.getSize(),uploadRequest.getPrice(), findLink);

        uploadRepository.save(uploadcake);
    }

    @Override
    public List<UploadCake> list() {
        return uploadRepository.findAll(Sort.by(Sort.Direction.ASC,"cakeNo"));
    }
}
