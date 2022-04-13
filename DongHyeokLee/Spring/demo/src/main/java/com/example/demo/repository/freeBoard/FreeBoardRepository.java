package com.example.demo.repository.freeBoard;

import com.example.demo.entitiy.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
}
