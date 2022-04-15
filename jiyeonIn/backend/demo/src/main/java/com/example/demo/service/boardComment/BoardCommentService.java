package com.example.demo.service.boardComment;

import com.example.demo.controller.boardCommentController.request.BoardCommentRequest;
import com.example.demo.entity.boardComment.BoardComment;

import java.util.List;

public interface BoardCommentService {

    public void includeCommentRegister(BoardCommentRequest info, String originalFilename);
    public void exceptFileCommentRegister(BoardCommentRequest info);
    public List<BoardComment> list();
}
