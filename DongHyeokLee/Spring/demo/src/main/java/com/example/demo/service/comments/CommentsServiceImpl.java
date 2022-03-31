package com.example.demo.service.comments;



import com.example.demo.controller.comments.request.CommentsRequest;
import com.example.demo.entitiy.comments.Comments;
import com.example.demo.repository.comments.CommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public void register(CommentsRequest commentsRequest) {


        Comments commentsEntity = new Comments(commentsRequest.getWriter(), commentsRequest.getContent(),commentsRequest.getBoardNo());

        commentsRepository.save(commentsEntity);
    }
}
