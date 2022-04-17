package com.example.demo.service.board.videoBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.videoBoard.VideoBoardComments;

import java.util.List;

public interface VideoBoardCommentsService {
    public void register (CommentRequest commentRequest);
    public List<VideoBoardComments> list (Integer boardNo);
    public void modify (VideoBoardComments videoBoardComments);
    public void remove (Integer boardNo);
}
