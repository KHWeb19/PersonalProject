package com.example.demo.service.myPage;

import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.MemberInfoResponse;
import com.example.demo.response.myPage.SavePlaceResponse;

import java.util.List;

public interface MyPageService {
    MemberInfoResponse memberInfo(String id);

    void memberInfoModify(MemberInfoModifyRequest memberInfoModifyRequest);

    List<SavePlaceResponse> memberSavePlaceList(String id);
}
