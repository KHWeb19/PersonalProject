package com.example.demo.repository;


import com.example.demo.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {
    @Query("select r from QuestionBoard r where r.id like :id")
    List<QuestionBoard> userRead(@Param("id") String id);
}
