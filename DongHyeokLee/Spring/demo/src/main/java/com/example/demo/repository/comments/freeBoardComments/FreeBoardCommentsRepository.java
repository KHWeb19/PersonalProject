package com.example.demo.repository.comments.freeBoardComments;

import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FreeBoardCommentsRepository extends JpaRepository<FreeBoardComments, Long> {

    @Query("select m from FreeBoardComments m where m.boardNo = :boardNo")
    List<FreeBoardComments> findComment(Long boardNo);
}
