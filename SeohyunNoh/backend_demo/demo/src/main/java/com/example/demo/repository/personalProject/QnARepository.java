package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QnARepository extends JpaRepository<QnABoard, Long> {
    @Query("select q from QnABoard q where q.id like :id")
    List<QnABoard> userRead(@Param("id") String id);
}
