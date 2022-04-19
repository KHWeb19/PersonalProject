package com.example.demo.service.board;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.CommentResponse;

import java.util.List;

public abstract class BaseCommentService {
    public abstract void register (Integer boardNo, CommentRequest commentRequest);
    public abstract List<CommentResponse> list (Integer boardNo);
    public abstract CommentResponse modify (Integer commentNo, CommentRequest commentRequest);
    public abstract void remove (Integer boardNo);
}
