package com.example.backend.service.board;

import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.BoardComments;
import com.example.backend.repository.Board.BoardCommentsRepository;
import com.example.backend.repository.Board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardCommentsServiceImpl implements BoardCommentsService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardCommentsRepository commentRepository;


    @Transactional
    @Override
    public void register(Integer boardNo, CommentRequest commentRequest) {
        Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

        Board board = maybeBoard.get();

        BoardComments comment = BoardComments.builder()
                .comment(commentRequest.getComment())
                .board(board)
                .commentWriter(commentRequest.getCommentWriter())
                .build();

        commentRepository.save(comment);
    }


    @Transactional
    @Override
    public List<BoardComments> list(Integer boardNo) {
        List<BoardComments> commentLists = commentRepository.findAllBoardCommentByBoardId(Long.valueOf(boardNo));

        return commentLists;
    }


    @Transactional
    @Override
    public BoardComments modify(Integer commentNo, CommentRequest commentRequest) {
        Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        Board board = maybeBoard.get();

        BoardComments commentModify = BoardComments.builder()
                .commentNo(Long.valueOf(commentNo))
                .board(board)
                .commentWriter(commentRequest.getCommentWriter())
                .comment(commentRequest.getComment())
                .regDate(commentRequest.getRegDate())
                .build();

        return commentRepository.save(commentModify);


    }


    @Transactional
    @Override
    public void remove(Integer commentNo) {
        commentRepository.deleteById(Long.valueOf(commentNo));

    }


}
