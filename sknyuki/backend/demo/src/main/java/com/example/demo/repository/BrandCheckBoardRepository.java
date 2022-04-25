package com.example.demo.repository;

import com.example.demo.entity.BrandCheckBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandCheckBoardRepository extends JpaRepository<BrandCheckBoard, Long> {
    @Query("select r from BrandCheckBoard r where r.id like :id")
    List<BrandCheckBoard> userRead(@Param("id") String id);
}
