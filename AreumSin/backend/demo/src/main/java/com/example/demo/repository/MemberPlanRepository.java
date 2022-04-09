package com.example.demo.repository;

import com.example.demo.entity.MemberPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPlanRepository extends JpaRepository<MemberPlan, Long> {
}
