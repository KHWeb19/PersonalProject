package com.example.demo.repository.board.freeBoard;

import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FreeBoardCommentsRepository extends JpaRepository<FreeBoardComments, Long> {

    @Query("select m from FreeBoardComments m join m.freeBoard tb where tb.boardNo = :boardNo")
    List<FreeBoardComments> findAllFreeBoardCommentsByBoardId(@Param("boardNo") Long boardNo);

}
