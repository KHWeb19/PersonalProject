package com.example.backend.repository;

import com.example.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Query("select b from Board b where b.writer = :writer")
//    Optional<Board> findAllByWriter(String writer);
}
