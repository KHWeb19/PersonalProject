package com.example.demo.repository.study;

import com.example.demo.entity.review.Review;
import com.example.demo.entity.review.ReviewComment;
import com.example.demo.entity.study.StudyBoard;
import com.example.demo.entity.study.StudyComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyCommentRepository extends JpaRepository<StudyComment, Long> {
    List<StudyComment> findStudyCommentByStudyBoard(StudyBoard studyBoard);
}
