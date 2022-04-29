package com.example.demo.controller;

import com.example.demo.entity.PlanDay;
import com.example.demo.request.*;
import com.example.demo.response.PlanDayResponse;
import com.example.demo.response.map.MapLikeListResponse;
import com.example.demo.response.map.MapLikeMarkListResponse;
import com.example.demo.response.map.SearchMapLikeListResponse;
import com.example.demo.service.plan.PlanDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/planDay")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class PlanDayController {

    @Autowired
    private PlanDayService planDayService;

    @PostMapping("/day")
    public void saveContent(@Validated @RequestBody PlanDayRequest planDayRequest){

        log.info("planDayRequest() : " + planDayRequest);

        planDayService.saveContent(planDayRequest);
    }

    @PostMapping("/list")
    public List<PlanDayResponse> planDayList(@Validated @RequestBody PlanDayListRequest planDayListRequest){

        log.info("planDayList() " + planDayListRequest.getPlanNo());

        List<PlanDay> planDay = planDayService.list(planDayListRequest);
        List<PlanDayResponse> planDayResponseList = new ArrayList<>();
        for(PlanDay planDays : planDay){
            log.info("planDayList : "+ planDays.getId());
            planDayResponseList.add(new PlanDayResponse(planDays.getId(), planDays.getPlanDayNo(), planDays.getContent(), planDays.getLikeCount(), planDays.getHateCount()));
        }

        return planDayResponseList;
    }

    @PostMapping("/like")
    public void likeContent(@Validated @RequestBody CountRequest countRequest){

        log.info("lickCount: "+ countRequest.getId());

        planDayService.like(countRequest);

    }

    @PostMapping("/hate")
    public void hateContent(@Validated @RequestBody CountRequest countRequest){

        log.info("hateContent: "+ countRequest.getId());

        planDayService.hate(countRequest);
    }

    @PostMapping("/remove")
    public Boolean removeContent(@Validated @RequestBody CountRequest countRequest){

        log.info("planDayNo : "+ countRequest);

        return planDayService.remove(countRequest);
    }

    @GetMapping("/mapLikeList/{planNo}")
    public List<MapLikeListResponse> likeMapList(@PathVariable("planNo") Integer planNo){

        log.info("likeMapList planNo: "+planNo);

        return planDayService.likePlaceList(planNo);
    }

    @GetMapping("/mapLikeMarkList/{planNo}")
    public List<MapLikeMarkListResponse> likeMarkList(@PathVariable("planNo") Integer planNo){

        log.info("likeMarkList planNo: "+planNo);

        return planDayService.likePlaceMarkList(planNo);
    }

    @PostMapping("/savePlaceDay")
    public void savePlaceDay (@RequestBody SaveFavoritePlaceDay saveFavoritePlaceDay){
        log.info("savePlaceDay: " + saveFavoritePlaceDay.getFavoritePlaceNo() + ", "+saveFavoritePlaceDay.getDay());

        planDayService.savePlaceDay(saveFavoritePlaceDay);
    }

    @PostMapping("/mapPlaceListDay")
    public List<MapLikeListResponse> mapPlaceListDay(@RequestBody SaveFavoritePlaceDayList saveFavoritePlaceDayList){
        log.info("savePlaceDay: " + saveFavoritePlaceDayList.getPlanNo() + ", "+saveFavoritePlaceDayList.getDay());

        return planDayService.listPlaceDay(saveFavoritePlaceDayList);
    }
}
