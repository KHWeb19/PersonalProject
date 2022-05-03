package com.example.backend.service;

import com.example.backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {

    void createPost(Post post);

    Post readPost(Integer post_id);

    Page<Post> getPosts(Pageable pageable);

    void modifyPost(Post post);

    void deletePost(Integer no);

}
