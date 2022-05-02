package com.example.demo.service.myPage;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.request.DiaryModifyRequest;
import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private JoinMemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SaveFavoritePlaceRepository placeRepository;

    @Autowired
    private MakePlanRepository planRepository;

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private DiaryImgRepository diaryImgRepository;

    @Override
    public MemberInfoResponse memberInfo(String id) {

        Member member = memberRepository.findByMemberNo(id);

        return new MemberInfoResponse(member.getMemberNo() ,member.getId(), member.getName(), member.getBirth(), member.getColor());
    }

    @Override
    public void memberInfoModify(MemberInfoModifyRequest memberInfoModifyRequest) {

        Member member = memberRepository.findByMemberNo(memberInfoModifyRequest.getId());

        member.setId(memberInfoModifyRequest.getId());
        member.setName(memberInfoModifyRequest.getName());
        member.setColor(memberInfoModifyRequest.getColor());
        member.setBirth(memberInfoModifyRequest.getBirth());

        if (memberInfoModifyRequest.getPw() != null){
            String encodePassword = passwordEncoder.encode(memberInfoModifyRequest.getPw());
            member.setPw(encodePassword);
        }

        memberRepository.save(member);

    }

    @Override
    public List<SavePlaceResponse> memberSavePlaceList(String id) {

        Member member = memberRepository.findByMemberNo(id);

        List<SaveFavoritePlace> saveFavoritePlace = placeRepository.findPlaceByUserNo(member.getMemberNo());

        List<SavePlaceResponse> savePlaceResponses = new ArrayList<>();

        for(SaveFavoritePlace place : saveFavoritePlace){
            Plan plan = planRepository.findByPlan(place.getPlan().getPlanNo());

            savePlaceResponses.add(new SavePlaceResponse(place.getTitle(), plan.getPlanName(), plan.getPlaceName()));
        }

        return savePlaceResponses;
    }

    @Override
    public void saveDiary(List<String> fileList, String id, String title, String content, String planName) {
         Member member = memberRepository.findByMemberNo(id);
         Diary diary = new Diary(planName, title, content, fileList.get(0), member);

        diaryRepository.save(diary);

        for(String fileName : fileList) {
             DiaryImg diaryImg = new DiaryImg(fileName, diary);

             diaryImgRepository.save(diaryImg);
         }

    }

    @Override
    public List<DiaryListResponse> diaryList(String id) {

        List<Diary> diaryList = diaryRepository.findDiaryByMemberId(id);

        List<DiaryListResponse> diaryListResponseArrayList = new ArrayList<>();

        for(Diary diary : diaryList){
            diaryListResponseArrayList.add(new DiaryListResponse(diary.getTitle(), diary.getPlanName(), diary.getDiaryNo(), diary.getDiarySrc()));
        }

        return diaryListResponseArrayList;
    }

    @Override
    public DiaryReadResponse diaryRead(Integer diaryNo) {

        Diary diary = diaryRepository.findByDiaryNo(diaryNo);

        return new DiaryReadResponse(diary.getTitle(), diary.getPlanName(), diary.getContent());
    }

    @Override
    public List<DiaryReadImgResponse> diaryReadImg(Integer diaryNo) {

        List<DiaryImg> diaryImg = diaryImgRepository.getByDiaryNo(diaryNo);

        List<DiaryReadImgResponse> diaryReadImgResponses = new ArrayList<>();

        for(DiaryImg diary : diaryImg){
            diaryReadImgResponses.add(new DiaryReadImgResponse(diary.getImgSrc(), diary.getDiaryImgNo()));
        }

        return diaryReadImgResponses;
    }

    @Override
    public void delete(Integer diaryNo) {

        List<DiaryImg> diaryImgs = diaryImgRepository.getByDiaryNo(diaryNo);

        diaryImgRepository.deleteAll(diaryImgs);

        diaryRepository.deleteById(diaryNo);
    }

    @Override
    public void modify(Integer diaryNo, DiaryModifyRequest diaryModifyRequest) {
        Diary diary = diaryRepository.findByDiaryNo(diaryNo);

        diary.setTitle(diaryModifyRequest.getTitle());
        diary.setContent(diaryModifyRequest.getContent());

        diaryRepository.save(diary);
    }

    @Override
    public void modifyImg(Integer diaryNo, List<Integer> diaryImgNo) {

        for(Integer num : diaryImgNo){
            diaryImgRepository.deleteById(num);
        }
    }

}
