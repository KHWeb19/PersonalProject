package com.example.demo.service.boardComment;

import com.example.demo.controller.boardCommentController.request.BoardCommentRequest;
import com.example.demo.entity.boardComment.BoardComment;
import com.example.demo.repository.boardComment.BoardCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    @Autowired
    BoardCommentRepository repository;

    @Override
    public void includeCommentRegister(BoardCommentRequest info, String originalFilename) {
        String putLink = info.getBookingNo()+"."+info.getId()+"."+originalFilename;

        BoardComment boardComment = new BoardComment(info.getId(),info.getComments(),info.getBookingNo(),putLink);
        repository.save(boardComment);
    }

    @Override
    public void exceptFileCommentRegister(BoardCommentRequest info) {
        BoardComment boardComment2 = new BoardComment(info.getId(),info.getComments(),info.getBookingNo());
        repository.save(boardComment2);

    }

    @Override
    public List<BoardComment> list() {
        return repository.findAll(Sort.by(Sort.Direction.ASC,"commentNo"));
    }
}
