package com.example.demo.service.personalProject;

import com.example.demo.controller.request.CommentDto;
import com.example.demo.entity.personalProject.Comment;
import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;

import java.util.List;

public interface CommentService {
    public Comment register(CommentDto commentDto);
    public List<Comment> read(Long qnaNo);
    public Comment readOnly(Long commentNo);
    public void modify(Comment comment, CommentDto commentDto);
    public void remove(Comment comment);
}
