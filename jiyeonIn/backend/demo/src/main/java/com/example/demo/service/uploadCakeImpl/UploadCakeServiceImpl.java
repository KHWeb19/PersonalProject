package com.example.demo.service.uploadCakeImpl;

import com.example.demo.controller.uploadFileController.request.UploadRequest;
import com.example.demo.entity.review.Review;
import com.example.demo.entity.uploadCake.UploadCake;
import com.example.demo.repository.upload.UploadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public List<UploadCake> list() {
        return uploadRepository.findAll(Sort.by(Sort.Direction.ASC,"cakeNo"));
    }

    @Transactional
    @Override
    public void includeImgModify(UploadCake info, String originalFilename) {

        String findLink = null;

        if(info.getDesign().equals("birthday")) {
            findLink = "birthday/" + originalFilename;
        } else if(info.getDesign().equals("family")) {
            findLink = "family/" + originalFilename;
        } else if(info.getDesign().equals("friend")) {
            findLink = "friend/" + originalFilename;
        } else if(info.getDesign().equals("lover")) {
            findLink = "lover/" + originalFilename;
        }

        UploadCake uploadcake = new UploadCake(info.getCakeNo(), info.getDesign(), info.getSize(),info.getPrice(), findLink);

        uploadRepository.save(uploadcake);

    }

    @Transactional
    @Override
    public void exceptImgModify(UploadCake info) {
        Optional<UploadCake> maybeUploadCake = uploadRepository.findInfo(info.getCakeNo());
        UploadCake findCake = maybeUploadCake.get();

        if(findCake.getLinkInfo() != null){
            info.setLinkInfo(findCake.getLinkInfo());
            uploadRepository.save(info);
        }else if(findCake.getLinkInfo() == null) {
            uploadRepository.save(info);
        }
    }

    @Override
    public void remove(Integer cakeNo) {
        uploadRepository.deleteById(Long.valueOf(cakeNo));
    }
}
