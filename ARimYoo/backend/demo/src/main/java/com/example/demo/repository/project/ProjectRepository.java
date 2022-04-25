package com.example.demo.repository.project;

import com.example.demo.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long> {

}
