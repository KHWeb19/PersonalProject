package com.example.demo.service.map;

import com.example.demo.request.SaveFavoritePlaceRequest;
import com.example.demo.response.map.SearchMapLikeListResponse;

import java.util.List;

public interface SaveFavoritePlaceService {
    void savePlace(SaveFavoritePlaceRequest placeRequest);

    List<SearchMapLikeListResponse> searchLikeList(String id);
}
