package com.example.demo.service.board;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.entity.board.CommunityCommentBox;
import com.example.demo.repository.board.CommunityBoardRepository;
import com.example.demo.repository.board.CommunityCommentBoxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommunityCommentBoxServiceImpl implements CommunityCommentBoxService{

    @Autowired
    CommunityBoardRepository boardRepository;

    @Autowired
    CommunityCommentBoxRepository repository;

   @Override
    public void register (Long boardNo, CommunityCommentBox communityCommentBox){
       Optional<CommunityBoard> boardItem = boardRepository.findById(Long.valueOf(boardNo));
       communityCommentBox.setCommunityBoard(boardItem.get());
       repository.save(communityCommentBox);
    }

    @Override
    public List<CommunityCommentBox> list (Long boardNo) {
       CommunityBoard communityBoard = boardRepository.findById(boardNo).get();
        return repository.findCommunityCommentBoxByCommunityBoard(communityBoard);
    }
}
