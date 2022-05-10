package com.example.demo.service.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignBoard;
import com.example.demo.entity.jpa.Foreign.ForeignComment;
import com.example.demo.repository.jpa.Foreign.ForeignBoardRepository;
import com.example.demo.repository.jpa.Foreign.ForeignCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ForeignCommentServiceImpl implements ForeignCommentService {

    @Autowired
    ForeignBoardRepository boardRepository;

    @Autowired
    ForeignCommentRepository repository;

    @Override
    public void register (Integer boardNo, ForeignComment foreignComment){
        Optional<ForeignBoard> boardItem = boardRepository.findById(Long.valueOf(boardNo));
        foreignComment.setForeignBoard(boardItem.get());
        repository.save(foreignComment);
    }

    @Override
    public List<ForeignComment> list (Integer boardNo) {
        ForeignBoard foreignBoard = boardRepository.findById(Long.valueOf(boardNo)).get();
        return repository.findForeignCommentByForeignBoard(foreignBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}