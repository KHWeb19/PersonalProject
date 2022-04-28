package com.example.demo.service;

import com.example.demo.entity.QuestionComment;
import com.example.demo.request.QuestionCommentDto;

import java.util.List;

public interface QuestionCommentService {
    QuestionComment add(QuestionCommentDto questionCommentDto) throws Exception;
    List<QuestionComment> read(Long boardNo) throws Exception;
    QuestionComment readOnly(Long commentNo) throws Exception;
    void modify(QuestionComment questionComment, QuestionCommentDto questionCommentDto) throws Exception;
    void remove(QuestionComment questionComment) throws Exception;

}
