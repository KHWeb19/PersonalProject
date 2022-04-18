package com.example.demo.service.board.videoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.entity.board.videoBoard.VideoBoardComments;
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
    public void register(CommentRequest commentRequest) {

        VideoBoardComments commentsEntity = new VideoBoardComments(commentRequest.getWriter(),
                commentRequest.getComment(),commentRequest.getBoardNo());

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
