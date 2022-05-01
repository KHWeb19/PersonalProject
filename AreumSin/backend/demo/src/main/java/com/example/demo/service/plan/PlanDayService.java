package com.example.demo.service.plan;

import com.example.demo.request.*;
import com.example.demo.response.PlanDayResponse;
import com.example.demo.response.map.MapLikeListResponse;
import com.example.demo.response.map.MapLikeMarkListResponse;

import java.util.List;

public interface PlanDayService {
    void saveContent(List<String> fileList, String id, Integer planNo, Integer day, String content);

    void saveContentNoImg(PlanDayRequest planDayRequest);

    List<PlanDayResponse> list(PlanDayListRequest planDayListRequest);

    void like(CountRequest countRequest);

    void hate(CountRequest countRequest);

    Boolean remove(CountRequest countRequest);

    List<MapLikeListResponse> likePlaceList(Integer planNo);

    List<MapLikeMarkListResponse> likePlaceMarkList(Integer planNo);

    void savePlaceDay(SaveFavoritePlaceDay saveFavoritePlaceDay);

    List<MapLikeListResponse> listPlaceDay(SaveFavoritePlaceDayList saveFavoritePlaceDayList);


}
