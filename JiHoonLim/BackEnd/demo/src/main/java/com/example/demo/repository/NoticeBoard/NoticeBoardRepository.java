package com.example.demo.repository.NoticeBoard;

import com.example.demo.entity.NoticeBoard.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

    @Transactional
    @Modifying
    @Query("update NoticeBoard vc set vc.viewCount = vc.viewCount + 1 where vc.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);
}
