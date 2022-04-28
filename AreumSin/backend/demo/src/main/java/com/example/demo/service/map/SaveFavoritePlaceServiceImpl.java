package com.example.demo.service.map;

import com.example.demo.entity.Plan;
import com.example.demo.entity.SaveFavoritePlace;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.SaveFavoritePlaceRepository;
import com.example.demo.request.SaveFavoritePlaceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveFavoritePlaceServiceImpl implements SaveFavoritePlaceService{

    @Autowired
    private SaveFavoritePlaceRepository saveFavoritePlaceRepository;

    @Autowired
    private MakePlanRepository makePlanRepository;

    @Override
    public void savePlace(SaveFavoritePlaceRequest placeRequest) {

        Plan plan = makePlanRepository.findByPlan(placeRequest.getPlanNo());

        SaveFavoritePlace favoritePlaceEntity = new SaveFavoritePlace(placeRequest.getPlaceTitle(), placeRequest.getPlaceX(), placeRequest.getPlaceY(), plan);

        saveFavoritePlaceRepository.save(favoritePlaceEntity);
    }
}
