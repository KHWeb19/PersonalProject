package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Transactional
    @Query("select b from Board b where b.boardNo = :boardNo")
    Board findBoardByBoardNo(Integer boardNo);

    @Transactional
    @Query("select b from Board b where b.place = :searchBoard")
    List<Board> findPlaceByPlace(String searchBoard);
}
