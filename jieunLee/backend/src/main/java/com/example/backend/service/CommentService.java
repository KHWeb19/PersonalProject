package com.example.backend.service;

import com.example.backend.entity.Comment;

import java.util.List;

public interface CommentService {
    public void register (Integer boardNo, Integer memberNo, Comment comment);
    List<Comment> list (Integer boardNo);
    public void modify (Comment comment);
    public void remove (Integer boardNo);
}
