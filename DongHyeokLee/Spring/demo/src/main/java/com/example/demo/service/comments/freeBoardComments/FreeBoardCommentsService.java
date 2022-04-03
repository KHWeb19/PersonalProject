package com.example.demo.service.comments.freeBoardComments;


import com.example.demo.controller.comments.freeBoardComments.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;

import java.util.List;

public interface FreeBoardCommentsService {
    public void register (FreeBoardCommentsRequest commentsRequest);
    public List<FreeBoardComments> list ();
}
