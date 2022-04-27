package com.example.backend.service;

import com.example.backend.entity.Post;
import java.util.List;

public interface PostService {

    void createPost(Post post);

    Post readPost(Integer post_id);

    List<Post> getPosts();

    void modifyPost(Post post);

}
