package com.example.demo.service.map;

import com.example.demo.entity.Member;
import com.example.demo.entity.Plan;
import com.example.demo.entity.SaveFavoritePlace;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.SaveFavoritePlaceRepository;
import com.example.demo.request.SaveFavoritePlaceRequest;
import com.example.demo.response.map.SearchMapLikeListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SaveFavoritePlaceServiceImpl implements SaveFavoritePlaceService{

    @Autowired
    private SaveFavoritePlaceRepository saveFavoritePlaceRepository;

    @Autowired
    private MakePlanRepository makePlanRepository;

    @Autowired
    private JoinMemberRepository memberRepository;

    @Override
    public void savePlace(SaveFavoritePlaceRequest placeRequest) {

        Member member = memberRepository.findByMemberNo(placeRequest.getId());

        Plan plan = makePlanRepository.findByPlan(placeRequest.getPlanNo());

        SaveFavoritePlace favoritePlaceEntity = new SaveFavoritePlace(placeRequest.getPlaceTitle(), placeRequest.getPlaceX(), placeRequest.getPlaceY(), plan, member);

        saveFavoritePlaceRepository.save(favoritePlaceEntity);
    }

    @Override
    public List<SearchMapLikeListResponse> searchLikeList(String id) {

        List<SaveFavoritePlace> searchLikeList = saveFavoritePlaceRepository.findAllByMemberId(id);

        List<SearchMapLikeListResponse> searchMapLikeListResponses = new ArrayList<>();
        for(SaveFavoritePlace saveFavoritePlace : searchLikeList){
            log.info(saveFavoritePlace.getTitle());
            searchMapLikeListResponses.add(new SearchMapLikeListResponse(saveFavoritePlace.getTitle()));
        }

        return searchMapLikeListResponses;
    }
}
