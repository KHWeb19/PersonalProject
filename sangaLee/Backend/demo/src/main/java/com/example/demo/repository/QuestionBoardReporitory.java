package com.example.demo.repository;

import com.example.demo.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBoardReporitory extends JpaRepository<QuestionBoard, Long> {
}
