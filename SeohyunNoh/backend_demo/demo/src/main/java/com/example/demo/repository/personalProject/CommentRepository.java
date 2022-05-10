package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByqnaNo(Long qnaNo);
}
