package com.example.demo.repository.board;

import com.example.demo.entity.Member;
import com.example.demo.entity.board.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {

}
