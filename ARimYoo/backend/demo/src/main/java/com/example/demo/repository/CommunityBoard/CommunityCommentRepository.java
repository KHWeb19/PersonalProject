package com.example.demo.repository.CommunityBoard;

import com.example.demo.entity.communityBoard.CommunityBoard;
import com.example.demo.entity.communityBoard.CommunityCommentBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityCommentRepository extends JpaRepository<CommunityCommentBox, Long> {
    List<CommunityCommentBox> findCommunityCommentByCommunityBoard(CommunityBoard communityBoard);
}
