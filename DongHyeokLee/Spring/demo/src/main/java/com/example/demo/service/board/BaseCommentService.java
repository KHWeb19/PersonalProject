package com.example.demo.service.board;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
import com.example.demo.dto.response.CommentResponse;

import java.util.List;

public abstract class BaseCommentService {
    public abstract void register (Integer boardNo, CommentRequest commentRequest);
    public abstract Object list (Integer boardNo);
    public abstract Object modify (Integer commentNo, CommentRequest commentRequest);
    public abstract void remove (Integer boardNo);
    public abstract void replyRegister (Integer boardNo, ReplyRequest commentRequest);
}
