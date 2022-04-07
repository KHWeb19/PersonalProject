package com.example.demo.controller;

import com.example.demo.entity.Plan;
import com.example.demo.service.plan.MakePlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MakePlanController {

    @Autowired
    private MakePlanService planService;

    @PostMapping("/makePlan")
    public Plan makePlan(@Validated @RequestBody Plan plan){
        log.info("makePlan()");

        planService.make(plan);

        return plan;
    }

}
