package com.example.demo.repository.board;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.entity.board.CommunityCommentBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityCommentBoxRepository extends JpaRepository<CommunityCommentBox, Long> {
    List<CommunityCommentBox> findCommunityCommentBoxByCommunityBoard(CommunityBoard communityBoard);
}
