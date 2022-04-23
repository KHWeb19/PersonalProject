package com.example.demo.repository;

import com.example.demo.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {
}
