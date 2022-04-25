package com.example.demo.repository.project;

import com.example.demo.entity.project.ProjectBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectBoardRepository extends JpaRepository <ProjectBoard, Long> {
    List<ProjectBoard> findByProjectNameContaining(String keyword);

}
