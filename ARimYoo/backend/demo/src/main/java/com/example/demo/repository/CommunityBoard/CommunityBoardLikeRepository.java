package com.example.demo.repository.CommunityBoard;

import com.example.demo.entity.Member;
import com.example.demo.entity.communityBoard.CommunityBoard;
import com.example.demo.entity.communityBoard.CommunityBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunityBoardLikeRepository extends JpaRepository<CommunityBoardLike, Long> {
    Optional<CommunityBoardLike> findByWhoAndCommunityBoard (String who, CommunityBoard communityBoard);
}
