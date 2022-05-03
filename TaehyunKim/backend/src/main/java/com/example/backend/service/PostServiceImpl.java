package com.example.backend.service;

import com.example.backend.entity.Post;
import com.example.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

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
    public Page<Post> getPosts(Pageable pageable) {

        return postRepository.findAll(pageable);
    }

    @Override
    public void modifyPost(Post post) {

        postRepository.save(post);
    }

    @Override
    public void deletePost(Integer no){
        postRepository.deleteById(Long.valueOf(no));
    }
}
