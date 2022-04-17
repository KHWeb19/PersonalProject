package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;

import java.util.List;

public interface FreeBoardCommentsService {
    public void register (Integer boardNo, CommentRequest commentRequest);
    public List<FreeBoardComments> list (Integer boardNo);
    public FreeBoardComments modify (Integer commentNo, CommentRequest commentsRequest);
    public void remove (Integer boardNo);
}
