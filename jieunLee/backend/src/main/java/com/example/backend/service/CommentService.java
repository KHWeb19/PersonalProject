package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;

import java.util.List;

public interface CommentService {
    public void register (Comment comment);
    List<Comment> boardNoCommentList (Integer boardNo);
}
