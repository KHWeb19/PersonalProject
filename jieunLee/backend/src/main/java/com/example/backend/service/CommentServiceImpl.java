package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repository;

    @Override
    public void register(Comment comment) {
        repository.save(comment);
    }

    @Override
    public List<Comment> boardNoCommentList(Integer boardNo) {
        List<Comment> boardComment = repository.selectBoardComment(Long.valueOf(boardNo));
        return boardComment;
    }
}
