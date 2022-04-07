package com.example.demo.service.plan;

import com.example.demo.entity.Plan;
import com.example.demo.repository.MakePlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MakePlanServiceImpl implements MakePlanService{

    @Autowired
    MakePlanRepository planRepository;

    @Override
    public void make(Plan plan) {
        log.info(String.valueOf(plan));
        planRepository.save(plan);
    }
}
