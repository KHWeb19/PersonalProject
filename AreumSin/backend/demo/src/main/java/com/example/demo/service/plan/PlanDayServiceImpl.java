package com.example.demo.service.plan;

import com.example.demo.entity.Plan;
import com.example.demo.entity.PlanDay;
import com.example.demo.repository.MakePlanRepository;
import com.example.demo.repository.PlanDayRepository;
import com.example.demo.request.PlanDayListRequest;
import com.example.demo.request.PlanDayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PlanDayServiceImpl implements PlanDayService{

    @Autowired
    private PlanDayRepository planDayRepository;

    @Autowired
    private MakePlanRepository makePlanRepository;

    @Override
    public void saveContent(PlanDayRequest planDayRequest) {

        Plan plan = makePlanRepository.findByPlan(planDayRequest.getPlanNo());

        PlanDay planDayEntity = PlanDay.createPlanDay(planDayRequest.getId(), planDayRequest.getContent(), planDayRequest.getDay(), plan);

        planDayRepository.save(planDayEntity);
    }

    @Override
    public List<PlanDay> list(PlanDayListRequest planDayListRequest) {

        List<PlanDay> planDayList = planDayRepository.findByDayContent(planDayListRequest.getPlanNo(), planDayListRequest.getDay());


        log.info("list() : " + String.valueOf(planDayList));

        log.info("여기까지 와?");
        for(PlanDay memberPlan : planDayList){
            log.info("여기!");
            log.info("PlanDay Content: " + memberPlan.getContent());
            log.info("PlanDay Id: " + memberPlan.getId());
        }

        return planDayList;
    }
}
