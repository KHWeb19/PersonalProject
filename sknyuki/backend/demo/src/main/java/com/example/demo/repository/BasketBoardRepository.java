package com.example.demo.repository;

import com.example.demo.entity.BasketBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketBoardRepository extends JpaRepository<BasketBoard, Long> {
    @Query("select r from BasketBoard r where r.id like :id")
    List<BasketBoard> userRead(@Param("id") String id);
}
