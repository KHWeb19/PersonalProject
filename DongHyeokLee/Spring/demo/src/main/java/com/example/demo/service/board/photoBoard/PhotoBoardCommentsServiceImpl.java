package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import com.example.demo.repository.board.photoBoard.PhotoBoardCommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class PhotoBoardCommentsServiceImpl implements PhotoBoardCommentsService {

    @Autowired
    private PhotoBoardCommentsRepository repository;

    @Override
    public void register(CommentRequest commentRequest) {

        PhotoBoardComments commentsEntity = new PhotoBoardComments(commentRequest.getWriter(),
                commentRequest.getComment(),commentRequest.getBoardNo());

        repository.save(commentsEntity);
    }

    @Override
    public List<PhotoBoardComments> list(Integer boardNo) {
        List<PhotoBoardComments> checkComments =repository.findComment(Long.valueOf(boardNo));

        return checkComments;
    }

    @Override
    public void modify(PhotoBoardComments photoBoardComments) {

        repository.save(photoBoardComments);

    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
