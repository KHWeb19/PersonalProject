package com.example.demo.service.board;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.repository.board.CommunityBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{

    @Autowired
    CommunityBoardRepository repository;

    @Override
    public void register (CommunityBoard board) {
        repository.save(board);
    }

    @Override
    public List<CommunityBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));

    }

}
