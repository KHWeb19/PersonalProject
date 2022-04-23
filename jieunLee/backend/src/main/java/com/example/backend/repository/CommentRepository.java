package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from comment where board_no in(select board_no from board where board_no = :boardNo)", nativeQuery = true)
    List<Comment> findAllByBoardNo(@Param("boardNo") Long boardNo);

    @Query(value = "select * from comment where board_no " +
            "in(select board_no from board where board_No = :boardNo) " +
            "order by comment_no desc limit 2",
            nativeQuery = true)
    List<Comment> findTop2ByBoardNo(@Param("boardNo") Long boardNo);

    Optional<Comment> findByBoard (Board board);
}


