package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {

    @Transactional
    @Modifying
    @Query("update FoodBoard vc set vc.vueCount = vc.vueCount + 1 where vc.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);
}
