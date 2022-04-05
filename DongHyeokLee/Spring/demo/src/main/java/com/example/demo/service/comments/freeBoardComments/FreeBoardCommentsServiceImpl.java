package com.example.demo.service.comments.freeBoardComments;



import com.example.demo.controller.comments.freeBoardComments.request.FreeBoardCommentsRequest;
import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;
import com.example.demo.entitiy.member.MemberInfo;
import com.example.demo.repository.comments.freeBoardComments.FreeBoardCommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class FreeBoardCommentsServiceImpl implements FreeBoardCommentsService {

    @Autowired
    private FreeBoardCommentsRepository commentsRepository;

    @Override
    public void register(FreeBoardCommentsRequest commentsRequest) {

        FreeBoardComments commentsEntity = new FreeBoardComments(commentsRequest.getWriter(),
                    commentsRequest.getContent(),commentsRequest.getBoardNo());

        commentsRepository.save(commentsEntity);
    }

    @Override
    public List<FreeBoardComments> list(Integer boardNo) {
        List<FreeBoardComments> checkComments =commentsRepository.findComment(Long.valueOf(boardNo));

        return checkComments;
    }

    @Override
    public void modify(FreeBoardComments freeBoardComments) {


        commentsRepository.save(freeBoardComments);

    }

    @Override
    public void remove(Integer commentNo) {
        commentsRepository.deleteById(Long.valueOf(commentNo));
    }
}
