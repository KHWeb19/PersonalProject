package com.example.demo.repository.board.photoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoBoardRepository extends JpaRepository<PhotoBoard, Long> {
}
