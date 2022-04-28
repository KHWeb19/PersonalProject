package com.example.demo.repository.study;

import com.example.demo.entity.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository <Study, Long> {
}
