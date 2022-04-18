package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.FreeBoardCommentResponse;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;

import java.util.List;

public interface FreeBoardCommentsService {
    public void register (Integer boardNo, CommentRequest commentRequest);
    public List<FreeBoardCommentResponse> list (Integer boardNo);
    public FreeBoardCommentResponse modify (Integer commentNo, CommentRequest commentsRequest);
    public void remove (Integer boardNo);
}
