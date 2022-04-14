package com.example.demo.service.board.freeBoard;



import com.example.demo.controller.board.freeBoard.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.CommentResponse;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.freeBoard.FreeBoardComments;
import com.example.demo.repository.board.freeBoard.FreeBoardCommentsRepository;
import com.example.demo.repository.board.freeBoard.FreeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class FreeBoardCommentsServiceImpl implements FreeBoardCommentsService {

    @Autowired
    private FreeBoardRepository boardRepository;

    @Autowired
    private FreeBoardCommentsRepository repository;

    @Override
    public void register(Integer boardNo, FreeBoardCommentsRequest commentsRequest) {
                Optional<FreeBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
                FreeBoard board = maybeBoard.get();
                log.info("************" + board);

        FreeBoardComments comment = FreeBoardComments.builder().
                comment(commentsRequest.getComment()).
                freeBoard(board).
                writer(commentsRequest.getWriter())
                        .build();


        repository.save(comment);
    }

    @Override
    public List<FreeBoardComments> list(Integer boardNo) {
        log.info("boardNo" + boardNo);
        List<FreeBoardComments> checkComments = repository.findAllFreeBoardCommentsByBoardId(Long.valueOf(boardNo));
        log.info("commentList" + checkComments);


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
