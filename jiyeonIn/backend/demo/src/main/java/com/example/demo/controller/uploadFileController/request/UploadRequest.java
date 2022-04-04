package com.example.demo.controller.uploadFileController.request;

import lombok.Data;

import java.io.File;

@Data
public class UploadRequest {
    private String design;
    private String size;
    private String price;

    public UploadRequest(String design, String size, String price) {
        this.design = design;
        this.size = size;
        this.price = price;
    }

    public UploadRequest() {

    }
}
