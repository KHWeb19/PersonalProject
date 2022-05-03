package com.example.demo.service.board.photoBoard;


import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.CommentResponse;

import java.util.List;

public interface PhotoBoardCommentsService {
    public void register (Integer boardNo, CommentRequest commentRequest);
   // public List<CommentResponse> list (Integer boardNo);
     //public CommentResponse modify (Integer commentNo, CommentRequest commentRequest);
    public void remove (Integer boardNo);
}
