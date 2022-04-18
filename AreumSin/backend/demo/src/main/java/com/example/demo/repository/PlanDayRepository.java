package com.example.demo.repository;

import com.example.demo.entity.PlanDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlanDayRepository extends JpaRepository<PlanDay, Long> {

    @Transactional
    @Query("select p from PlanDay p where p.plan.planNo = :planNo and p.day = :day")
    List<PlanDay> findByDayContent(Integer planNo, Integer day);
}
