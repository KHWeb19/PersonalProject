package com.example.demo.service.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.entity.jpa.Local.LocalComment;
import com.example.demo.repository.jpa.Local.LocalBoardRepository;
import com.example.demo.repository.jpa.Local.LocalCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LocalCommentServiceImpl implements LocalCommentService{

    @Autowired
    LocalBoardRepository boardRepository;

    @Autowired
    LocalCommentRepository repository;

    @Override
    public void register (Integer boardNo, LocalComment localComment){
        Optional<LocalBoard> boardItem = boardRepository.findById(Long.valueOf(boardNo));
        localComment.setLocalBoard(boardItem.get());
        repository.save(localComment);
    }

    @Override
    public List<LocalComment> list (Integer boardNo) {
        LocalBoard localBoard = boardRepository.findById(Long.valueOf(boardNo)).get();
        return repository.findLocalCommentByLocalBoard(localBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}