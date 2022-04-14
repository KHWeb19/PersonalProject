package com.example.demo.service.board.photoBoard;

import com.example.demo.controller.board.photoBoard.request.PhotoBoardCommentsRequest;
import com.example.demo.entitiy.board.photoBoard.PhotoBoardComments;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PhotoBoardCommentsService {
    public void register (PhotoBoardCommentsRequest commentsRequest);
    public List<PhotoBoardComments> list (Integer boardNo);
    public void modify (PhotoBoardComments photoBoardComments);
    public void remove (Integer boardNo);
}
