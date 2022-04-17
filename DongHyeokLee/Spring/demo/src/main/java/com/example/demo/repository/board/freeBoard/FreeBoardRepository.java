package com.example.demo.repository.board.freeBoard;

import com.example.demo.entity.board.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    List<FreeBoard> findByContentContaining(String keyWord);
}
