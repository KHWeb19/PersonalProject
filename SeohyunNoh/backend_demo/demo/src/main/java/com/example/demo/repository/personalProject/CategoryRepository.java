package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
