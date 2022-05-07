package com.example.backend.service.serviceCenter;

import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.controller.serviceBoard.CenterCommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.BoardComments;
import com.example.backend.entity.Center;
import com.example.backend.entity.CenterComments;
import com.example.backend.repository.Board.BoardCommentsRepository;
import com.example.backend.repository.Board.BoardRepository;
import com.example.backend.repository.centerBoard.CenterCommentsRepository;
import com.example.backend.repository.centerBoard.CenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CenterCommentsServiceImpl implements CenterCommentsService {

    @Autowired
    private CenterRepository cenRepository;

    @Autowired
    private CenterCommentsRepository cenCommentRepository;


    @Transactional
    @Override
    public void register(Integer centerNo, CenterCommentRequest centerCommentRequest) {
        Optional<Center> maybeBoard = cenRepository.findById(Long.valueOf(centerNo));

        Center center = maybeBoard.get();

        CenterComments comment = CenterComments.builder()
                .comment(centerCommentRequest.getComment())
                .center(center)
                .commentWriter(centerCommentRequest.getCommentWriter())
                .build();

        cenCommentRepository.save(comment);
    }


    @Transactional
    @Override
    public List<CenterComments> list(Integer centerNo) {

        //List<CenterComments> commentLists = commentRepository.findAllBoardCommentByBoardId(Long.valueOf(centerNo));

        //return commentLists;

        Center center = cenRepository.findById(Long.valueOf(centerNo)).get();

        return cenCommentRepository.findCenterCommentsByCenter(center);
    }


    @Transactional
    @Override
    public CenterComments modify(Integer comNo, CenterCommentRequest centerCommentRequest) {
        Optional<Center> maybeBoard = cenRepository.findById(Long.valueOf(centerCommentRequest.getCenterNo()));
        Center center = maybeBoard.get();

        CenterComments commentModify = CenterComments.builder()
                .comNo(Long.valueOf(comNo))
                .center(center)
                .commentWriter(centerCommentRequest.getCommentWriter())
                .comment(centerCommentRequest.getComment())
                .regDate(centerCommentRequest.getRegDate())
                .build();

        return cenCommentRepository.save(commentModify);


    }



    @Override
    public void remove(Integer comNo) {
        cenCommentRepository.deleteById(Long.valueOf(comNo));

    }

}
