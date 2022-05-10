package com.example.backend.service;

import com.example.backend.entity.Comments;
import com.example.backend.entity.Post;
import com.example.backend.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class CommentsServiceImpl implements CommentsService{

    private final CommentsRepository commentsRepository;

    @Override
    public void createComment(Comments comments, Post post) {

        comments.setPost(post);
        post.getComments().add(comments);

        commentsRepository.save(comments);
    }

    @Override
    public Page<Comments> listComments(Post post, Pageable pageable) {

        return commentsRepository.findAllByPost(post, pageable);

    }

    @Override
    public Optional<Comments> readComment(Integer no) {
        return commentsRepository.findById(Long.valueOf(no));
    }

    @Override
    public void deleteComments(Integer no) {

        commentsRepository.deleteById(Long.valueOf(no));
    }
}
