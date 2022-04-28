package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {

    @Transactional
    @Modifying
    @Query("update FoodBoard vc set vc.viewCount = vc.viewCount + 1 where vc.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);

    @Transactional
    @Modifying
    @Query("update FoodBoard lc set lc.likeCount = lc.likeCount + 1 where lc.boardNo = :boardNo")
    void updateLikeCount(@Param("boardNo") Long boardNo);

    List<FoodBoard> findTop10ByOrderByRankScoreDesc();

    List<FoodBoard> findByNameContaining(String keyWord);

    @Transactional
    @Modifying
    @Query("update FoodBoard rs set rs.rankScore = rs.viewCount + (2 * rs.likeCount) where rs.boardNo = :boardNo")
    void setRankScore(@Param("boardNo") Long boardNo);
}
