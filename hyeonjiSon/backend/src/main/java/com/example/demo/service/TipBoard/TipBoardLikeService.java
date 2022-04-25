package com.example.demo.service.TipBoard;

import com.example.demo.entity.TipBoard;
import com.example.demo.entity.TipBoardLike;
import com.example.demo.repository.TipBoardLikeRepository;
import com.example.demo.repository.TipBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipBoardLikeService {

    @Autowired
    private TipBoardLikeRepository likeRepository;

    @Autowired
    private TipBoardRepository boardRepository;

    public boolean addLike (String who, Long boardNo) {
        TipBoard tipBoard = boardRepository.findById(boardNo).orElseThrow();

        // 중복 좋아요 방지
        if (likeRepository.findByWhoAndTipBoard(who, tipBoard).isEmpty()) {
            likeRepository.save(new TipBoardLike(who, tipBoard));
            return true;
        }
        return false;
    }
}
