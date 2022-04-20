package com.example.backend.repository.Board;

import com.example.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository  extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyWord);
}

