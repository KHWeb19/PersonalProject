package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.freeBoard.FreeBoardComments;
import com.example.demo.repository.board.freeBoard.FreeBoardCommentsRepository;
import com.example.demo.repository.board.freeBoard.FreeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void register(Integer boardNo, CommentRequest commentRequest) {
                Optional<FreeBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
                FreeBoard board = maybeBoard.get();
                /*board.setCommentCnt(board.getCommentCnt()+1);
                boardRepository.save(board);*/

                FreeBoardComments comment = FreeBoardComments.builder()
                        .comment(commentRequest.getComment())
                        .freeBoard(board)
                        .writer(commentRequest.getWriter())
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
    public FreeBoardComments modify(Integer commentNo, CommentRequest commentRequest) {

        Optional<FreeBoard> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        FreeBoard board = maybeBoard.get();

        FreeBoardComments commentModify = FreeBoardComments.builder()
                                        .commentNo(Long.valueOf(commentNo))
                                        .freeBoard(board)
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
