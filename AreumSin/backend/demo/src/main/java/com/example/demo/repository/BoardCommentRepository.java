package com.example.demo.repository;

import com.example.demo.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer> {

    @Transactional
    @Query("select bc from BoardComment bc where bc.board.boardNo = :boardNo")
    List<BoardComment> findByBoardNo(Integer boardNo);
}
