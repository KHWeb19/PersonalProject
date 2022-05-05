package com.example.demo.service.myPage;

import com.example.demo.request.DiaryModifyRequest;
import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.*;

import java.util.List;

public interface MyPageService {
    MemberInfoResponse memberInfo(String id);

    void memberInfoModify(MemberInfoModifyRequest memberInfoModifyRequest);

    List<SavePlaceResponse> memberSavePlaceList(String id);

    void saveDiary(List<String> fileList, String id, String title, String content, String planName);

    List<DiaryListResponse> diaryList(String id);

    DiaryReadResponse diaryRead(Integer diaryNo);

    List<DiaryReadImgResponse> diaryReadImg(Integer diaryNo);

    void delete(Integer diaryNo);

    void modify(Integer diaryNo, DiaryModifyRequest diaryModifyRequest);

    void modifyImg(Integer diaryNo, List<Integer> diaryImgNo);
}
