package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.entity.uploadCake.UploadCake;

import java.util.List;

public interface UploadCakeService {
    public void register(UploadRequest uploadRequest, String originalFilename);
    public List<UploadCake> list();
    public void includeImgModify(UploadCake info, String originalFilename);
    public void exceptImgModify(UploadCake info);
    public void remove(Integer cakeNo);
}
