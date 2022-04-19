package com.example.demo.service.board.videoBoard;

import com.example.demo.dto.request.CommentRequest;
import com.example.demo.dto.response.CommentResponse;
import com.example.demo.entity.board.videoBoard.VideoBoard;
import com.example.demo.entity.board.videoBoard.VideoBoardComments;
import com.example.demo.repository.board.videoBoard.VideoBoardCommentsRepository;
import com.example.demo.repository.board.videoBoard.VideoBoardRepository;
import com.example.demo.service.board.BaseCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class VideoBoardCommentsServiceImpl extends BaseCommentService {

    @Autowired
    private VideoBoardCommentsRepository repository;

    @Autowired
    private VideoBoardRepository boardRepository;

    @Override
    public void register(Integer boardNo, CommentRequest commentRequest) {
        Optional<VideoBoard> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));

        VideoBoard board = maybeBoard.get();

        VideoBoardComments comment = VideoBoardComments.builder()
                .comment(commentRequest.getComment())
                .videoBoard(board)
                .writer(commentRequest.getWriter())
                .build();

        repository.save(comment);
    }

    @Override
    public List<CommentResponse> list(Integer boardNo) {
        List<VideoBoardComments> checkComments
                = repository.findAllPhotoBoardCommentsByBoardId(Long.valueOf(boardNo));

        List<CommentResponse> response = new ArrayList<>();

        for(VideoBoardComments comment : checkComments){
            response.add(new CommentResponse(comment.getWriter(),
                    comment.getComment(), comment.getVideoBoard().getBoardNo(),
                    comment.getRegDate(),comment.getCommentNo()));
        }

        return response;
    }

    @Override
    public CommentResponse modify(Integer commentNo, CommentRequest commentRequest) {
        Optional<VideoBoard> maybeBoard = boardRepository.findById(Long.valueOf(commentRequest.getBoardNo()));
        VideoBoard board = maybeBoard.get();

        VideoBoardComments commentModify = VideoBoardComments.builder()
                .commentNo(Long.valueOf(commentNo))
                .videoBoard(board)
                .comment(commentRequest.getComment())
                .writer(commentRequest.getWriter())
                .regDate(commentRequest.getRegDate())
                .build();

        repository.save(commentModify);

        CommentResponse response
                =new CommentResponse(commentModify.getWriter(), commentModify.getComment(),
                                                commentModify.getVideoBoard().getBoardNo(),
                                                commentModify.getRegDate(), commentModify.getCommentNo());

                     return response;

    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
