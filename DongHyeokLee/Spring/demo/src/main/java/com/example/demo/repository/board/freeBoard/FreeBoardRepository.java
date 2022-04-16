package com.example.demo.repository.board.freeBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    List<FreeBoard> findByContentContaining(String keyWord);
}
