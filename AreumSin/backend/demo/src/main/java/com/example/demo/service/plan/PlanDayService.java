package com.example.demo.service.plan;

import com.example.demo.entity.PlanDay;
import com.example.demo.request.*;
import com.example.demo.response.map.MapLikeListResponse;
import com.example.demo.response.map.MapLikeMarkListResponse;
import com.example.demo.response.map.SearchMapLikeListResponse;

import java.util.List;

public interface PlanDayService {
    void saveContent(PlanDayRequest planDayRequest);

    List<PlanDay> list(PlanDayListRequest planDayListRequest);

    void like(CountRequest countRequest);

    void hate(CountRequest countRequest);

    Boolean remove(CountRequest countRequest);

    List<MapLikeListResponse> likePlaceList(Integer planNo);

    List<MapLikeMarkListResponse> likePlaceMarkList(Integer planNo);

    void savePlaceDay(SaveFavoritePlaceDay saveFavoritePlaceDay);

    List<MapLikeListResponse> listPlaceDay(SaveFavoritePlaceDayList saveFavoritePlaceDayList);
}
