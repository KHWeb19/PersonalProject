package com.example.demo.controller;

import com.example.demo.entity.PlanDay;
import com.example.demo.request.PlanDayListRequest;
import com.example.demo.request.PlanDayRequest;
import com.example.demo.response.PlanDayResponse;
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
            planDayResponseList.add(new PlanDayResponse(planDays.getId(), planDays.getContent()));
        }

        return planDayResponseList;
    }
}
