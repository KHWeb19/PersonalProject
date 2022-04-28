package com.example.demo.repository.CommunityBoard;

import com.example.demo.entity.communityBoard.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {
    List<CommunityBoard> findByTitleContaining(String keyword);

    List<CommunityBoard> findTop5ByOrderByLikeCntDesc ();
}
