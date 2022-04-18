package com.example.demo.service.board.photoBoard;


import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;

import java.util.List;

public interface PhotoBoardCommentsService {
    public void register (Integer boardNo, CommentRequest commentRequest);
    public List<PhotoBoardComments> list (Integer boardNo);
    public PhotoBoardComments modify (Integer commentNo, CommentRequest commentRequest);
    public void remove (Integer boardNo);
}
