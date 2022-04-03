package com.example.demo.repository.board.freeBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
}
