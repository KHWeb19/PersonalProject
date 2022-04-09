package com.example.demo.repository.board;

import com.example.demo.entity.board.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {

//    @Modifying
//    @Query("update CommunityBoard b set b.viewCnt + 1 where b.boardNo = :boardNo ")
//    int updateView(Long boardNo);

}
