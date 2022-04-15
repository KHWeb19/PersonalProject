package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c join c.board b where b.boardNo = :boardNo")
    List<Comment> findCommentByBoardNo(@Param("boardNo") Long boardNo);
}
