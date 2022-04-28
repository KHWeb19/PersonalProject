package com.example.demo.service;


import com.example.demo.entity.QuestionComment;
import com.example.demo.repository.QuestionCommentRepository;
import com.example.demo.request.QuestionCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class QuestionCommentServiceImpl implements QuestionCommentService {
    @Autowired
    QuestionCommentRepository repository;

    @Override
    public QuestionComment add(QuestionCommentDto questionCommentDto) throws Exception {
        QuestionComment questionComment = repository.save(questionCommentDto.toEntity());

        return questionComment;
    }

    @Override
    public List<QuestionComment> read(Long boardNo) throws Exception {
        List<QuestionComment> questionComments = repository.findByBoardNo(boardNo);

        return questionComments;
    }

    @Override
    public QuestionComment readOnly(Long commentNo) throws Exception {
        QuestionComment questionComment = repository.findById(commentNo).orElseThrow();

        return questionComment;
    }

    @Override
    public void modify(QuestionComment questionComment, QuestionCommentDto questionCommentDto) throws Exception {
        questionComment.updateContent(questionCommentDto);

        repository.save(questionComment);
    }

    @Override
    public void remove(QuestionComment questionComment) throws Exception {
        repository.delete(questionComment);
    }
}
