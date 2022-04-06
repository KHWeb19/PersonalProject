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
    public void register(UploadRequest uploadRequest) {

        UploadCake uploadcake = new UploadCake(uploadRequest.getDesign(), uploadRequest.getSize(),uploadRequest.getPrice());

        uploadRepository.save(uploadcake);
    }
}
