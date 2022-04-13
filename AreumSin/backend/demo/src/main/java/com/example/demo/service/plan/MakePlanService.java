package com.example.demo.service.plan;

import com.example.demo.entity.MemberPlan;
import com.example.demo.request.MemberPlanRequest;

import java.util.List;


public interface MakePlanService {
    void make(MemberPlanRequest memberPlanRequest);
    List<MemberPlan> listPlan(Integer id);
}
