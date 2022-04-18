package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.FreeBoardCommentResponse;
import com.example.demo.entity.board.freeBoard.FreeBoard;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;
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
    public List<FreeBoardCommentResponse> list(Integer boardNo) {

        List<FreeBoardComments> checkComments = repository.findAllFreeBoardCommentsByBoardId(Long.valueOf(boardNo));
        List<FreeBoardCommentResponse> response = new ArrayList<>();
        for(FreeBoardComments comment : checkComments){
            response.add(new FreeBoardCommentResponse(comment.getWriter(), comment.getComment(),
                                                    comment.getFreeBoard().getBoardNo(),
                                                    comment.getRegDate(),comment.getCommentNo()));

        }

        return response;
    }

    @Override
    public FreeBoardCommentResponse modify(Integer commentNo, CommentRequest commentRequest) {

        Optional<FreeBoard> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        FreeBoard board = maybeBoard.get();

        FreeBoardComments commentModify = FreeBoardComments.builder()
                                        .commentNo(Long.valueOf(commentNo))
                                        .freeBoard(board)
                                        .comment(commentRequest.getComment())
                                        .writer(commentRequest.getWriter())
                                        .regDate(commentRequest.getRegDate())
                                        .build();

        repository.save(commentModify);

        FreeBoardCommentResponse response = new FreeBoardCommentResponse(commentModify.getWriter(),
                                        commentModify.getComment(), commentModify.getFreeBoard().getBoardNo(),
                                        commentModify.getRegDate(), commentModify.getCommentNo());

        return response;
    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
