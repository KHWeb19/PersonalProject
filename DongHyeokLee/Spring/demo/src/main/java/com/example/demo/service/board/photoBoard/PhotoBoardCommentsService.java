package com.example.demo.service.board.photoBoard;


import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;

import java.util.List;

public interface PhotoBoardCommentsService {
    public void register (CommentRequest commentRequest);
    public List<PhotoBoardComments> list (Integer boardNo);
    public void modify (PhotoBoardComments photoBoardComments);
    public void remove (Integer boardNo);
}
