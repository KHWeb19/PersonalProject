package com.example.demo.repository;

import com.example.demo.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardImgRepository extends JpaRepository<BoardImg, Integer> {

    @Transactional
    @Query("select bi from BoardImg bi where bi.board.boardNo = :boardNo")
    List<BoardImg> findImageByBoardNo(Integer boardNo);

    @Transactional
    @Query("select bi from BoardImg bi where bi.boardImgNo = :boardImgNo")
    BoardImg findByBoardImgNo(Integer boardImgNo);
}
