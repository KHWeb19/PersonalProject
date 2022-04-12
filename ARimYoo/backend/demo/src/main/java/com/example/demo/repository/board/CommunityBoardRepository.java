package com.example.demo.repository.board;

import com.example.demo.entity.board.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {

}
