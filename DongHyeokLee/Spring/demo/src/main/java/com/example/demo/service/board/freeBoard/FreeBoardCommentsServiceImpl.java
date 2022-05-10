package com.example.demo.service.board.freeBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.entity.board.freeBoard.FreeBoard;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.example.demo.repository.board.freeBoard.FreeBoardCommentsRepository;
import com.example.demo.repository.board.freeBoard.FreeBoardRepository;
import com.example.demo.service.board.BaseCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class FreeBoardCommentsServiceImpl extends BaseCommentService {

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Autowired
    private FreeBoardCommentsRepository freeBoardCommentsRepository;

    @Override
    public void register(Integer boardNo, CommentRequest commentRequest) {
                Optional<FreeBoard> maybeBoard = freeBoardRepository.findById(Long.valueOf(boardNo));
                FreeBoard board = maybeBoard.get();
                /*board.setCommentCnt(board.getCommentCnt()+1);
                boardRepository.save(board);*/

                FreeBoardComments comment = FreeBoardComments.builder()
                        .comment(commentRequest.getComment())
                        .freeBoard(board)
                        .writer(commentRequest.getWriter())
                        .build();

        freeBoardCommentsRepository.save(comment);
    }

    @Override
    public Object list(Integer boardNo) {
       List<FreeBoardComments> checkComments =
               freeBoardCommentsRepository.findAllFreeBoardCommentsByBoardId(Long.valueOf(boardNo));
        List<CommentResponse> response = new ArrayList<>();


        for(FreeBoardComments comment : checkComments){
            if(comment.getReply() == null) {
                response.add(new CommentResponse(comment.getWriter(), comment.getComment(),
                        comment.getFreeBoard().getBoardNo(),
                        comment.getRegDate(), comment.getCommentNo(),
                        null));
            }else{
                response.add(new CommentResponse(comment.getWriter(), comment.getComment(),
                                                comment.getFreeBoard().getBoardNo(),
                                                comment.getRegDate(), comment.getCommentNo(),
                                                comment.getReply().getCommentNo()));
            }
        }

        List<CommentResponse> response2 = new ArrayList<>();

        for(int i = 0; i < response.size(); i++){
            if(response.get(i).getParCommentNo() == null){
                response2.add(response.get(i));
                for(int y=0; y< response.size(); y++) {
                    if (response.get(y).getParCommentNo() != null) {
                        if (response.get(y).getParCommentNo() == response.get(i).getCommentNo()) {
                            response2.add(response.get(y));
                        }

                    }
                }
            }
        }
        return response2;
    }

   @Override
    public Object modify(Integer commentNo, CommentRequest commentRequest) {

        Optional<FreeBoard> maybeBoard = freeBoardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        FreeBoard board = maybeBoard.get();

        FreeBoardComments reply = freeBoardCommentsRepository.findByCommentNo(Long.valueOf(commentNo));

        FreeBoardComments commentModify = FreeBoardComments.builder()
                                        .commentNo(Long.valueOf(commentNo))
                                        .freeBoard(board)
                                        .reply(reply.getReply())
                                        .comment(commentRequest.getComment())
                                        .writer(commentRequest.getWriter())
                                        .regDate(commentRequest.getRegDate())
                                        .build();

        return freeBoardCommentsRepository.save(commentModify);


    }

    @Override
    public void remove(Integer commentNo) {
        freeBoardCommentsRepository.deleteById(Long.valueOf(commentNo));
    }

    @Override
    public void replyRegister(Integer boardNo, ReplyRequest commentRequest) {
        Optional<FreeBoard> maybeBoard2 = freeBoardRepository.findById(Long.valueOf(boardNo));
        FreeBoard board2 = maybeBoard2.get();

        Optional<FreeBoardComments> maybeBoard = freeBoardCommentsRepository.findById(commentRequest.getCommentNo());
        FreeBoardComments board = maybeBoard.get();


        FreeBoardComments comment = FreeBoardComments.builder()
                .reply(board)
                .freeBoard(board2)
                .comment(commentRequest.getReply())
                .writer(commentRequest.getWriter())
                .build();

        freeBoardCommentsRepository.save(comment);
    }
}
