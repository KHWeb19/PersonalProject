package com.example.demo.service.comments;


import com.example.demo.controller.comments.request.CommentsRequest;
import com.example.demo.entitiy.comments.Comments;

public interface CommentsService {
    public void register (CommentsRequest commentsRequest);
}
