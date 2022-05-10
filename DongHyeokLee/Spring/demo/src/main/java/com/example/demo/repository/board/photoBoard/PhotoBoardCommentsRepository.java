package com.example.demo.repository.board.photoBoard;

import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoBoardCommentsRepository extends JpaRepository<PhotoBoardComments, Long> {

    @Query("select m from PhotoBoardComments m join m.photoBoard tb where tb.boardNo = :boardNo")
    List<PhotoBoardComments> findAllPhotoBoardCommentsByBoardId(@Param("boardNo") Long boardNo);

    @Query("select m from PhotoBoardComments m where m.commentNo = :commentNo")
    PhotoBoardComments findByCommentNo(@Param("commentNo") Long commentNo);
}
