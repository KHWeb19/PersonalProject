package com.example.backend.service.board;

import com.example.backend.controller.board.request.CommentRequest;

import com.example.backend.entity.BoardComments;

import java.util.List;

public interface BoardCommentsService {
    public void register (Integer boardNo, CommentRequest commentRequest);
    public List<BoardComments> list (Integer boardNo);
    public BoardComments modify (Integer commentNo, CommentRequest commentsRequest);
    public void remove (Integer boardNo);

}
