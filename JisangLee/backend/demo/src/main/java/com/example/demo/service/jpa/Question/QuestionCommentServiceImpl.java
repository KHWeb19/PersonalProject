package com.example.demo.service.jpa.Question;

import com.example.demo.entity.jpa.Question.QuestionBoard;
import com.example.demo.entity.jpa.Question.QuestionComment;
import com.example.demo.repository.jpa.Question.QuestionBoardRepository;
import com.example.demo.repository.jpa.Question.QuestionCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionCommentServiceImpl implements QuestionCommentService {

    @Autowired
    QuestionBoardRepository boardRepository;

    @Autowired
    QuestionCommentRepository repository;

    @Override
    public void register (Integer boardNo, QuestionComment questionComment){
        Optional<QuestionBoard> boardItem = boardRepository.findById(Long.valueOf(boardNo));
        questionComment.setQuestionBoard(boardItem.get());
        repository.save(questionComment);
    }

    @Override
    public List<QuestionComment> list (Integer boardNo) {
        QuestionBoard questionBoard = boardRepository.findById(Long.valueOf(boardNo)).get();
        return repository.findQuestionCommentByQuestionBoard(questionBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}