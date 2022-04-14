package com.example.demo.service.board.videoBoard;

import com.example.demo.controller.board.videoBoard.request.VideoBoardCommentsRequest;
import com.example.demo.entitiy.board.videoBoard.VideoBoardComments;
import com.example.demo.repository.board.videoBoard.VideoBoardCommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class VideoBoardCommentsServiceImpl implements VideoBoardCommentsService {

    @Autowired
    private VideoBoardCommentsRepository repository;

    @Override
    public void register(VideoBoardCommentsRequest commentsRequest) {

        VideoBoardComments commentsEntity = new VideoBoardComments(commentsRequest.getWriter(),
                    commentsRequest.getContent(),commentsRequest.getBoardNo());

        repository.save(commentsEntity);
    }

    @Override
    public List<VideoBoardComments> list(Integer boardNo) {
        List<VideoBoardComments> checkComments =repository.findComment(Long.valueOf(boardNo));

        return checkComments;
    }

    @Override
    public void modify(VideoBoardComments videoBoardComments) {

        repository.save(videoBoardComments);

    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
