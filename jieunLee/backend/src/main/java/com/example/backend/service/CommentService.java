package com.example.backend.service;

import com.example.backend.controller.CommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;

import java.util.List;

public interface CommentService {
    public void register (Integer boardNo, CommentRequest commentRequest);
    List<Comment> list (Integer boardNo);
    public void remove (Integer boardNo);
}
