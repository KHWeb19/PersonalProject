package com.example.backend.service;

import com.example.backend.controller.CommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository repository;

    @Override
    public void register(Integer boardNo, Comment comment) {

        Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
        comment.setBoard(maybeBoard.get());

        repository.save(comment);
    }

    @Override
    public List<Comment> list(Integer boardNo) {
        return repository.findAllByBoardNo(Long.valueOf(boardNo));
    }

    @Override
    public List<Comment> twoList(Integer boardNo) {
        return repository.findTop2ByBoardNo(Long.valueOf(boardNo));
    }

    @Override
    public void modify(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
