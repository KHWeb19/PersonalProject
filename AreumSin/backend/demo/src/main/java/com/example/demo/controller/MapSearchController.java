package com.example.demo.controller;

import com.example.demo.request.SaveFavoritePlaceRequest;
import com.example.demo.service.map.SaveFavoritePlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


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
}
