package com.example.demo.service.board.freeBoard;



import com.example.demo.controller.board.freeBoard.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoardComments;
import com.example.demo.repository.board.freeBoard.FreeBoardCommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Slf4j
@Service
public class FreeBoardCommentsServiceImpl implements FreeBoardCommentsService {

    @Autowired
    private FreeBoardCommentsRepository repository;

    @Override
    public void register(FreeBoardCommentsRequest commentsRequest) {

        FreeBoardComments commentsEntity = new FreeBoardComments(commentsRequest.getWriter(),
                    commentsRequest.getContent(),commentsRequest.getBoardNo());

        repository.save(commentsEntity);
    }

    @Override
    public List<FreeBoardComments> list(Integer boardNo) {
        List<FreeBoardComments> checkComments =repository.findComment(Long.valueOf(boardNo));

        return checkComments;
    }

    @Override
    public void modify(FreeBoardComments freeBoardComments) {


        repository.save(freeBoardComments);

    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
