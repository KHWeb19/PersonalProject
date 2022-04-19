package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.List;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {

    @Transactional
    @Modifying
    @Query("update FoodBoard vc set vc.viewCount = vc.viewCount + 1 where vc.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);

    List<FoodBoard> findTop10ByOrderByViewCountDesc();

    List<FoodBoard> findByNameContaining(String keyWord);
}
