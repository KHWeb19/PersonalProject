package com.example.demo.repository;

import com.example.demo.entity.ProductBoardS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductBoardSRepository extends JpaRepository<ProductBoardS, Long> {
    @Query("select r from ProductBoardS r where r.id like :id")
    List<ProductBoardS> userRead(@Param("id") String id);
}
