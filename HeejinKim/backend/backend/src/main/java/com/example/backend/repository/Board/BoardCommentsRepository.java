package com.example.backend.repository.Board;

import com.example.backend.entity.BoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardCommentsRepository extends JpaRepository<BoardComments,Long> {

    @Query("select c from BoardComments c join c.board tb where tb.boardNo = :boardNo")
    List<BoardComments> findAllBoardCommentByBoardId(Long boardNo);
}
