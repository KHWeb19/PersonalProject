package com.example.demo.controller;

import com.example.demo.entity.Diary;
import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.MemberInfoResponse;
import com.example.demo.response.myPage.SavePlaceResponse;
import com.example.demo.service.myPage.MyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/myPage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @PostMapping("/{id}")
    public MemberInfoResponse memberInfo(@PathVariable("id") String id){
        log.info("memberInfo() : " + id);


        return myPageService.memberInfo(id);
    }

    @PutMapping("/{id}")
    public void memberInfoModify(@PathVariable("id") String id, @RequestBody MemberInfoModifyRequest memberInfoModifyRequest){
        log.info("memberInfoModify() : " + memberInfoModifyRequest.getId());


        myPageService.memberInfoModify(memberInfoModifyRequest);
    }

    @PostMapping("/savePlace/{id}")
    public List<SavePlaceResponse> savePlaceList(@PathVariable("id") String id){
        log.info("savePlaceList() : " + id);

        return myPageService.memberSavePlaceList(id);
    }

    @PostMapping("/writeDiary{id}")
    public void saveDiaryImg(@PathVariable("id") String id,
                             @RequestParam("fileList") List<MultipartFile> fileList,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("planName") String planName){
        log.info("saveDiaryImg : "+ planName);

    }
}
