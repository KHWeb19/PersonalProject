package com.example.demo.service.Board;

import com.example.demo.entity.Board.Comment;

import java.util.List;

public interface CommentService {
    public void register(Comment comment, Long boardNo);
    public List<Comment> list (Long boardNo);
    public void delete (Long boardNo);
}
