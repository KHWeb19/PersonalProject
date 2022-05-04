package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.request.ReplyRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import com.example.demo.repository.board.photoBoard.PhotoBoardCommentsRepository;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;
import com.example.demo.service.board.BaseCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PhotoBoardCommentsServiceImpl extends BaseCommentService {

    @Autowired
    private PhotoBoardCommentsRepository  photoBoardCommentsRepository;

    @Autowired
    private PhotoBoardRepository photoBoardRepository;

    @Override
    public void register(Integer boardNo, CommentRequest commentRequest) {

        Optional<PhotoBoard> maybeBoard = photoBoardRepository.findById(Long.valueOf(boardNo));
        PhotoBoard board = maybeBoard.get();

        PhotoBoardComments comment = PhotoBoardComments.builder()
                .comment(commentRequest.getComment())
                .photoBoard(board)
                .writer(commentRequest.getWriter())
                .build();

        photoBoardCommentsRepository.save(comment);
    }

    @Override
    public Object list(Integer boardNo) {
        List<PhotoBoardComments> checkComments =
                photoBoardCommentsRepository.findAllPhotoBoardCommentsByBoardId(Long.valueOf(boardNo));
        List<CommentResponse> response = new ArrayList<>();


        for(PhotoBoardComments comment : checkComments){
            if(comment.getReply() == null) {
                response.add(new CommentResponse(comment.getWriter(), comment.getComment(),
                        comment.getPhotoBoard().getBoardNo(),
                        comment.getRegDate(), comment.getCommentNo(),
                        null));
            }else{
                response.add(new CommentResponse(comment.getWriter(), comment.getComment(),
                        comment.getPhotoBoard().getBoardNo(),
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

        Optional<PhotoBoard> maybeBoard = photoBoardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        PhotoBoard board = maybeBoard.get();

        PhotoBoardComments reply = photoBoardCommentsRepository.findByCommentNo(Long.valueOf(commentNo));

        PhotoBoardComments commentModify = PhotoBoardComments.builder()
                .commentNo(Long.valueOf(commentNo))
                .photoBoard(board)
                .reply(reply.getReply())
                .comment(commentRequest.getComment())
                .writer(commentRequest.getWriter())
                .regDate(commentRequest.getRegDate())
                .build();

        return photoBoardCommentsRepository.save(commentModify);


    }

    @Override
    public void remove(Integer commentNo) {
        photoBoardCommentsRepository.deleteById(Long.valueOf(commentNo));
    }

    @Override
    public void replyRegister(Integer boardNo, ReplyRequest commentRequest) {
        Optional<PhotoBoard> maybeBoard2 = photoBoardRepository.findById(Long.valueOf(boardNo));
        PhotoBoard board2 = maybeBoard2.get();

        Optional<PhotoBoardComments> maybeBoard = photoBoardCommentsRepository.findById(commentRequest.getCommentNo());
        PhotoBoardComments board = maybeBoard.get();


        PhotoBoardComments comment = PhotoBoardComments.builder()
                .reply(board)
                .photoBoard(board2)
                .comment(commentRequest.getReply())
                .writer(commentRequest.getWriter())
                .build();

        photoBoardCommentsRepository.save(comment);
    }
}
