package com.example.demo.repository.jpa.Question;

import com.example.demo.entity.jpa.Question.QuestionBoard;
import com.example.demo.entity.jpa.Question.QuestionComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionCommentRepository extends JpaRepository<QuestionComment, Long> {
    List<QuestionComment> findQuestionCommentByQuestionBoard(QuestionBoard questionBoard);
}



