package com.example.demo.repository.board.freeBoard;

import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface FreeBoardCommentsRepository extends JpaRepository<FreeBoardComments, Long> {

    @Query("select m from FreeBoardComments m join m.freeBoard tb where tb.boardNo = :boardNo")
    List<FreeBoardComments> findAllFreeBoardCommentsByBoardId(@Param("boardNo") Long boardNo);

    @Query("select m from FreeBoardComments m where m.commentNo = :commentNo")
    FreeBoardComments findByCommentNo(@Param("commentNo") Long commentNo);

}
