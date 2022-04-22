package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.CommentDto;
import com.example.demo.entity.personalProject.Comment;
import com.example.demo.entity.personalProject.QnABoard;
import com.example.demo.repository.personalProject.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment register(CommentDto commentDto) {
        Comment comment = commentRepository.save(commentDto.toEntity());

        return comment;
    }

    @Override
    public List<Comment> read(Long qnaNo) {
        List<Comment> comments = commentRepository.findByqnaNo(qnaNo);

        return comments;
    }

    @Override
    public Comment readOnly(Long commentNo) {
        Comment comment = commentRepository.findById(commentNo).orElseThrow();

        return comment;
    }

    @Override
    public void modify(Comment comment, CommentDto commentDto) {
        comment.updateContent(commentDto);

        commentRepository.save(comment);
    }

    @Override
    public void remove(Comment comment) {
        commentRepository.delete(comment);
    }
}
