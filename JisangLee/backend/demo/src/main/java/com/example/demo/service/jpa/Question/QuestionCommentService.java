package com.example.demo.service.jpa.Question;

import com.example.demo.entity.jpa.Question.QuestionComment;

import java.util.List;

public interface QuestionCommentService {
    public void register (Integer boardNo, QuestionComment questionComment);
    public List<QuestionComment> list (Integer boardNo);
    public void delete (Long commentId);
}


