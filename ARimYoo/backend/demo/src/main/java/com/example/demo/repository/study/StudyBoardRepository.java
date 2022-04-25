package com.example.demo.repository.study;

import com.example.demo.entity.study.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyBoardRepository extends JpaRepository <StudyBoard, Long> {
    List<StudyBoard> findByStudyNameContaining(String keyword);

}
