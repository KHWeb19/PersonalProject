package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.uploadCake.UploadCake;

import java.util.List;

public interface UploadCakeService {
    public void register(UploadRequest uploadRequest, String originalFilename);

    public List<UploadCake> list();
}
