package com.example.demo.service.plan;

import com.example.demo.entity.PlanDay;
import com.example.demo.request.PlanDayListRequest;
import com.example.demo.request.PlanDayRequest;

import java.util.List;

public interface PlanDayService {
    void saveContent(PlanDayRequest planDayRequest);

    List<PlanDay> list(PlanDayListRequest planDayListRequest);
}
