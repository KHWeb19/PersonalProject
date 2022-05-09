package com.example.backend.repository.noticeBoard;


import com.example.backend.entity.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface  NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

    @Transactional
    @Modifying
    @Query("update NoticeBoard nb set nb.viewCount = nb.viewCount + 1 where nb.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);
}
