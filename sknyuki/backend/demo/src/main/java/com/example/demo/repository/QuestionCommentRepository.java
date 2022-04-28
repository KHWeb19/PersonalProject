package com.example.demo.repository;

import com.example.demo.entity.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {
    List<QuestionComment> findByBoardNo(Long boardNo);
}

