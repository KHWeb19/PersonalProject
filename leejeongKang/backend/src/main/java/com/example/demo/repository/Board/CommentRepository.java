package com.example.demo.repository.Board;

import com.example.demo.entity.Board.Board;
import com.example.demo.entity.Board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByBoard(Board board);
}
