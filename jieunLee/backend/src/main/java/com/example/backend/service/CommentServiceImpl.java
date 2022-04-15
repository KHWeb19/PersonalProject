package com.example.backend.service;

import com.example.backend.controller.CommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register(Integer boardNo, CommentRequest commentRequest) {

        Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
        Board board = maybeBoard.get();

        Comment commentEntity = Comment.builder().
                content(commentRequest.getContent()).
                board(board).
                writer(commentRequest.getWriter())
                .build();

        boardRepository.save(board);
        repository.save(commentEntity);
    }

    @Override
    public List<Comment> list(Integer boardNo) {
        List<Comment> comments = repository.findCommentByBoardNo(Long.valueOf(boardNo));
        return comments;
    }
}
