package com.example.demo.repository.board.videoBoard;

import com.example.demo.entitiy.board.videoBoard.VideoBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoBoardCommentsRepository extends JpaRepository<VideoBoardComments, Long> {

    @Query("select m from VideoBoardComments m where m.boardNo = :boardNo")
    List<VideoBoardComments> findComment(Long boardNo);
}
