package com.example.demo.service.board.freeBoard;


import com.example.demo.controller.board.freeBoard.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoardComments;

import java.util.List;

public interface FreeBoardCommentsService {
    public void register (Integer boardNo, FreeBoardCommentsRequest commentsRequest);
    public List<FreeBoardComments> list (Integer boardNo);
    public void modify (FreeBoardComments freeBoardComments);
    public void remove (Integer boardNo);
}
