package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.upload.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UploadCakeServiceImpl implements UploadCakeService{

    @Autowired
    UploadRepository uploadRepository;

    @Transactional
    @Override
    public void register(UploadRequest uploadRequest, String originalFilename) {

        String findLink = null;
        if(uploadRequest.getDesign().equals("birthday")) {
            findLink = "@/assets/uploadImg/birthday/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("family")) {
            findLink = "@/assets/uploadImg/family/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("friend")) {
            findLink = "@/assets/uploadImg/friend/" + originalFilename;
        } else if(uploadRequest.getDesign().equals("lover")) {
            findLink = "@/assets/uploadImg/lover/" + originalFilename;
        }

        UploadCake uploadcake = new UploadCake(uploadRequest.getDesign(), uploadRequest.getSize(),uploadRequest.getPrice(), findLink);

        uploadRepository.save(uploadcake);
    }

    @Override
    public void familyImg(String originalFilename) {
        String familyname = "@/assets/uploadImg/birthday/" + originalFilename;
    }

    @Override
    public void friendImg(String originalFilename) {

    }

    @Override
    public void loverImg(String originalFilename) {

    }

    @Override
    public void birthdayImg(String originalFilename) {

    }
}
