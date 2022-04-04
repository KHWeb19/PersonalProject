package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;

public interface UploadCakeService {
    public void register(UploadRequest uploadRequest, String originalFilename);

    public void familyImg(String originalFilename);

    public void friendImg(String originalFilename);

    public void loverImg(String originalFilename);

    public void birthdayImg(String originalFilename);
}
