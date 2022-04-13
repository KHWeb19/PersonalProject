package com.example.demo.repository.comments;

import com.example.demo.entitiy.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
