package com.example.demo.service.board.videoBoard;

import com.example.demo.controller.board.videoBoard.request.VideoBoardCommentsRequest;
import com.example.demo.entitiy.board.videoBoard.VideoBoardComments;

import java.util.List;

public interface VideoBoardCommentsService {
    public void register (VideoBoardCommentsRequest commentsRequest);
    public List<VideoBoardComments> list (Integer boardNo);
    public void modify (VideoBoardComments videoBoardComments);
    public void remove (Integer boardNo);
}
