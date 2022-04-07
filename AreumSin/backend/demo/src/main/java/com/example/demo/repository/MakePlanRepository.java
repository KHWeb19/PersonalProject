package com.example.demo.repository;

import com.example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakePlanRepository extends JpaRepository<Plan, Long> {

}
