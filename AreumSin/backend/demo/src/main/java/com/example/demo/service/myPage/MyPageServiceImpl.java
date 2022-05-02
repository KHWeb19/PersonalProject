package com.example.demo.service.myPage;

import com.example.demo.entity.Member;
import com.example.demo.entity.Plan;
import com.example.demo.entity.SaveFavoritePlace;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.SaveFavoritePlaceRepository;
import com.example.demo.request.MemberInfoModifyRequest;
import com.example.demo.response.myPage.MemberInfoResponse;
import com.example.demo.response.myPage.SavePlaceResponse;
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

}
