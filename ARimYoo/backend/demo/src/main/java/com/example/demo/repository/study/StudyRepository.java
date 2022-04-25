package com.example.demo.repository.study;

import com.example.demo.entity.study.Study;
import com.example.demo.entity.study.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository <Study, Long> {

}
