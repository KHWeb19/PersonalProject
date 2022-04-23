package com.example.demo.service.communityBoard;

import com.example.demo.entity.communityBoard.CommunityBoard;
import com.example.demo.entity.communityBoard.CommunityBoardLike;
import com.example.demo.repository.CommunityBoard.CommunityBoardLikeRepository;
import com.example.demo.repository.CommunityBoard.CommunityBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardLikeService{

    @Autowired
    private CommunityBoardLikeRepository likeRepository;

    @Autowired
    private CommunityBoardRepository boardRepository;

    public boolean addLike (String who, Long boardNo) {
        CommunityBoard communityBoard = boardRepository.findById(boardNo).orElseThrow();

        // 중복 좋아요 방지
        if (likeRepository.findByWhoAndCommunityBoard(who, communityBoard).isEmpty()) {
            likeRepository.save(new CommunityBoardLike(who, communityBoard));
            return true;
        }
        return false;
    }
}
