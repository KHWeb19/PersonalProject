package com.example.demo.repository;

import com.example.demo.entity.PlanDayImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlanDayImgRepository extends JpaRepository<PlanDayImg, Integer> {

    @Transactional
    @Query("select pdi from PlanDayImg pdi where pdi.planDay.day = :day")
    List<PlanDayImg> findByPlanDay(Integer day);
}
