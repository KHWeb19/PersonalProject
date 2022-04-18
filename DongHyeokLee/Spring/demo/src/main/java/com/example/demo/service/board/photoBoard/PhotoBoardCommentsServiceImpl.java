package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import com.example.demo.repository.board.photoBoard.PhotoBoardCommentsRepository;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PhotoBoardCommentsServiceImpl implements PhotoBoardCommentsService {

    @Autowired
    private PhotoBoardCommentsRepository repository;

    @Autowired
    private PhotoBoardRepository boardRepository;

    @Override
    public void register(Integer boardNo, CommentRequest commentRequest) {

        Optional<PhotoBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
        PhotoBoard board = maybeBoard.get();

        PhotoBoardComments comment = PhotoBoardComments.builder()
                .comment(commentRequest.getComment())
                .boardPhoto(board)
                .writer(commentRequest.getWriter())
                .build();

        repository.save(comment);
    }

    @Override
    public List<PhotoBoardComments> list(Integer boardNo) {
        log.info("boardNo" + boardNo);
        List<PhotoBoardComments> checkComments = repository.findAllPhotoBoardCommentsByBoardId(Long.valueOf(boardNo));
        log.info("commentList" + checkComments);


        return checkComments;
    }

    @Override
    public PhotoBoardComments modify(Integer commentNo, CommentRequest commentRequest) {

        Optional<PhotoBoard> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        PhotoBoard board = maybeBoard.get();

        PhotoBoardComments commentModify = PhotoBoardComments.builder()
                .commentNo(Long.valueOf(commentNo))
                .boardPhoto(board)
                .comment(commentRequest.getComment())
                .writer(commentRequest.getWriter())
                .regDate(commentRequest.getRegDate())
                .build();

        return repository.save(commentModify);

    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
