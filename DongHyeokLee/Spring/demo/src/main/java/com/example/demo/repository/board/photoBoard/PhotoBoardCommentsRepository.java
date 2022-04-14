package com.example.demo.repository.board.photoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoBoardCommentsRepository extends JpaRepository<PhotoBoardComments, Long> {

    @Query("select m from PhotoBoardComments m where m.boardNo = :boardNo")
    List<PhotoBoardComments> findComment(@Param("boardNo") Long boardNo);
}
