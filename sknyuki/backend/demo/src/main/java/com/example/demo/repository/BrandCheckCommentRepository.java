package com.example.demo.repository;

import com.example.demo.entity.BrandCheckComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCheckCommentRepository extends JpaRepository<BrandCheckComment, Long> {
    List<BrandCheckComment> findByBoardNo(Long boardNo);
}

