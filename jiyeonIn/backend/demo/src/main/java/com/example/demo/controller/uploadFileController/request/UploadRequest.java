package com.example.demo.controller.uploadFileController.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadRequest {
    private String design;
    private String size;
    private String price;


}
