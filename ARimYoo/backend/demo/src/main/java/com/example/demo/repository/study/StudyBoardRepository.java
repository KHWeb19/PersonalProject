package com.example.demo.repository.study;

import com.example.demo.entity.study.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyBoardRepository extends JpaRepository <StudyBoard, Long> {

}
