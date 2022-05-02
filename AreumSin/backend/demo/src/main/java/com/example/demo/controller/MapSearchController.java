package com.example.demo.controller;

import com.example.demo.request.SaveFavoritePlaceRequest;
import com.example.demo.response.map.SearchMapLikeListResponse;
import com.example.demo.service.map.SaveFavoritePlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/map")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MapSearchController {

    @Autowired
    private SaveFavoritePlaceService saveFavoritePlaceService;

    @PostMapping("/savePlace")
    public void savePlace(@RequestBody SaveFavoritePlaceRequest placeRequest){

        log.info("x: " + placeRequest.getPlaceX()
        + " y : " + placeRequest.getPlaceY()
        + "title : " + placeRequest.getPlaceTitle()
        + "planNo : " + placeRequest.getPlanNo());

        saveFavoritePlaceService.savePlace(placeRequest);
    }

    @GetMapping("/searchList/{id}")
    public List<SearchMapLikeListResponse> searchMapLikeList(@PathVariable("id") String id){
        log.info("searchMapLikeList() " + id);

       return saveFavoritePlaceService.searchLikeList(id);
       //return null;
    }
}
