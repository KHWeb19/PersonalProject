package com.example.demo.repository;

import com.example.demo.entity.ProductBoardB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductBoardBRepository extends JpaRepository<ProductBoardB, Long> {
    @Query("select r from ProductBoardB r where r.id like :id")
    List<ProductBoardB> userRead(@Param("id") String id);
}
