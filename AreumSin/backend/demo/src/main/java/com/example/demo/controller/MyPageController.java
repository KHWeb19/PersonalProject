package com.example.demo.controller;

import com.example.demo.entity.Diary;
import com.example.demo.request.DiaryModifyRequest;
import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.*;
import com.example.demo.service.myPage.MyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
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

    @PostMapping("/writeDiary/{id}")
    public void saveDiaryImg(@PathVariable("id") String id,
                             @RequestParam("fileList") List<MultipartFile> fileList,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("planName") String planName){
        log.info("saveDiaryImg : "+ planName);

        List<String> fileName = new ArrayList<>();
        log.info("fileList() "+fileList);

        try{
            for(MultipartFile multipartFile : fileList){
                log.info("requestUploadFile() - Make file: " + multipartFile.getOriginalFilename());

                FileOutputStream file = new FileOutputStream("../../frontend/src/assets/diary/" + id + "_" + multipartFile.getOriginalFilename());

                String fileSrc = id + "_" + multipartFile.getOriginalFilename();
                fileName.add(fileSrc);

                file.write(multipartFile.getBytes());
                file.close();
            }

            myPageService.saveDiary(fileName, id, title, content, planName);
        } catch (Exception e){
            log.info("fail");
        }
    }

    @PostMapping("/diaryList/{id}")
    public List<DiaryListResponse> diaryList(@PathVariable("id") String id){
        log.info("diaryList() : "+id);

        return myPageService.diaryList(id);
    }

    @PostMapping("readDiary/{diaryNo}")
    public DiaryReadResponse diaryRead(@PathVariable("diaryNo") Integer diaryNo){
        log.info("diaryRead() : " + diaryNo);

        return myPageService.diaryRead(diaryNo);
    }

    @PostMapping("readDiary/img/{diaryNo}")
    public List<DiaryReadImgResponse> diaryReadImg(@PathVariable("diaryNo") Integer diaryNo){
        log.info("diaryReadImg() : " + diaryNo);

        return myPageService.diaryReadImg(diaryNo);
    }

    @DeleteMapping("/{diaryNo}")
    public void diaryDelete(@PathVariable("diaryNo") Integer diaryNo){
        log.info("diaryDelete() : "+ diaryNo);

        myPageService.delete(diaryNo);
    }

    @PutMapping("/diaryModify/{diaryNo}")
    public void diaryModify(@PathVariable("diaryNo") Integer diaryNo, @RequestBody DiaryModifyRequest diaryModifyRequest){
        log.info("diaryModify() : " + diaryModifyRequest.getTitle());

        myPageService.modify(diaryNo, diaryModifyRequest);
    }

    @PostMapping("/diaryModifyImg/{diaryNo}")
    public void diaryModifyImg(@PathVariable("diaryNo") Integer diaryNo, @RequestParam("diaryImgNo") List<Integer> diaryImgNo){

        log.info("diaryModifyImg() " + diaryNo + ", " + diaryImgNo.get(0));

        myPageService.modifyImg(diaryNo, diaryImgNo);
    }
}
