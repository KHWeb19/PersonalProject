package com.example.demo.service.comments.freeBoardComments;



import com.example.demo.controller.comments.freeBoardComments.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;
import com.example.demo.repository.comments.freeBoardComments.FreeBoardCommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class FreeBoardCommentsServiceImpl implements FreeBoardCommentsService {

    @Autowired
    private FreeBoardCommentsRepository commentsRepository;

    @Override
    public void register(FreeBoardCommentsRequest commentsRequest) {


        FreeBoardComments commentsEntity = new FreeBoardComments(commentsRequest.getWriter(), commentsRequest.getContent(),commentsRequest.getBoardNo());

        commentsRepository.save(commentsEntity);
    }

    @Override
    public List<FreeBoardComments> list() {
        return commentsRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }
}
