package com.example.demo.repository.NoticeBoard;

import com.example.demo.entity.NoticeBoard.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
}
