package com.example.backend.service;

import com.example.backend.entity.Post;
import com.example.backend.entity.User;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void createPost(Post post) {

        postRepository.save(post);
    }

    @Override
    public Post readPost(Integer post_id) {

        Optional<Post> result = postRepository.findById(Long.valueOf(post_id));

        return result.isEmpty() ? null : result.get();

    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public void modifyPost(Post post) {

        postRepository.save(post);
    }
}
