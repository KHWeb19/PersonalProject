package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
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


       List<FreeBoardComments> checkComments =
                repository.findAllFreeBoardCommentsByBoardId(Long.valueOf(boardNo));
        List<FreeBoardCommentResponse> response = new ArrayList<>();


        for(FreeBoardComments comment : checkComments){
            log.info(""+ comment.getReply());
            response.add(new FreeBoardCommentResponse(comment.getWriter(), comment.getComment(),
                                                    comment.getFreeBoard().getBoardNo(),
                                                    comment.getRegDate(),comment.getCommentNo(),comment.getReply())
            );

        }

        List<FreeBoardCommentResponse> response2 = new ArrayList<>();

        for(int i = 0; i < response.size(); i++){
            if(response.get(i).getFreeBoardComments() == null){
                response2.add(response.get(i));
                for(int y=0; y< response.size(); y++) {
                    if (response.get(y).getFreeBoardComments() != null) {
                        if (response.get(y).getFreeBoardComments().getCommentNo() == response.get(i).getCommentNo()) {
                            response2.add(response.get(y));
                        }

                    }
                }
            }
        }
        log.info("response***" + response2);

        return response2;
    }

   @Override
    public Object modify(Integer commentNo, CommentRequest commentRequest) {

        Optional<FreeBoard> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        FreeBoard board = maybeBoard.get();

        FreeBoardComments commentModify = FreeBoardComments.builder()
                                        .commentNo(Long.valueOf(commentNo))
                                        .freeBoard(board)
                                        .reply(commentRequest.getFreeBoardComment())
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

    @Override
    public void replyRegister(Integer boardNo, ReplyRequest commentRequest) {
        Optional<FreeBoard> maybeBoard2 = boardRepository.findById(Long.valueOf(boardNo));
        FreeBoard board2 = maybeBoard2.get();

        Optional<FreeBoardComments> maybeBoard = repository.findById(commentRequest.getParCommentNo());
        FreeBoardComments board = maybeBoard.get();


        FreeBoardComments comment = FreeBoardComments.builder()
                .reply(board)
                .freeBoard(board2)
                .comment(commentRequest.getReply())
                .writer(commentRequest.getWriter())
                .build();

        repository.save(comment);
    }
}
