package com.example.backend.repository.jpa;

import com.example.backend.entity.jpa.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(@Param("title") String title);
}
