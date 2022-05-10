package com.example.backend.service;

import com.example.backend.entity.Comments;
import com.example.backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CommentsService {

    void createComment(Comments comments, Post post);

    Page<Comments> listComments(Post post, Pageable pageable);

    Optional<Comments> readComment(Integer no);

    void deleteComments(Integer no);

}
