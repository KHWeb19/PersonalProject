package com.example.demo.repository.boardComment;

import com.example.demo.entity.boardComment.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment,Long> {
}
