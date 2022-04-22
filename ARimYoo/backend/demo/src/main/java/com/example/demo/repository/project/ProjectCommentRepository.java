package com.example.demo.repository.project;

import com.example.demo.entity.project.ProjectBoard;
import com.example.demo.entity.project.ProjectComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectCommentRepository extends JpaRepository<ProjectComment, Long> {
    List<ProjectComment> findProjectCommentByProjectBoard(ProjectBoard projectBoard);
}
