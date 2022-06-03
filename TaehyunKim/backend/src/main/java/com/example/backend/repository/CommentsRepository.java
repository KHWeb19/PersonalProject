package com.example.backend.repository;

import com.example.backend.entity.Comments;
import com.example.backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    Page<Comments> findAllByPost(Post post, Pageable pageable);

}
