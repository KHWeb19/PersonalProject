package com.example.demo.repository.board.videoBoard;

import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import com.example.demo.entity.board.videoBoard.VideoBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoBoardCommentsRepository extends JpaRepository<VideoBoardComments, Long> {

    @Query("select m from VideoBoardComments m join m.videoBoard tb where tb.boardNo = :boardNo")
    List<VideoBoardComments> findAllPhotoBoardCommentsByBoardId(@Param("boardNo") Long boardNo);
}
