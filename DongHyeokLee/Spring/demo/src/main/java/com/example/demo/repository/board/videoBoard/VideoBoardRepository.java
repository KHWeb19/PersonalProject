package com.example.demo.repository.board.videoBoard;

import com.example.demo.entitiy.board.videoBoard.VideoBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VideoBoardRepository extends JpaRepository<VideoBoard, Long> {

    @Query("select m.fileName from VideoBoard m where m.boardNo = :boardNo")
    Optional<VideoBoard> findFileName(Long boardNo);
}
