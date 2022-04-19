package com.example.demo.repository.board.videoBoard;

import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.example.demo.entity.board.videoBoard.VideoBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface VideoBoardLikeRepository extends JpaRepository<VideoBoardLike, Long> {

    @Transactional
    @Query("select m from VideoBoardLike m where m.writer = :writer")
    List<VideoBoardLike> findByWriter(@Param("writer")String writer);

    @Query("select m from VideoBoardLike m join m.videoBoard tb where tb.boardNo = :boardNo and m.writer = :writer")
    Optional<VideoBoardLike> findId(@Param("boardNo")Long boardNo, @Param("writer")String writer);

    @Query("select m from VideoBoardLike m where m.videoBoard.boardNo = :boardNo")
    List<VideoBoardLike> findByBoardNo(@Param("boardNo")Long boardNo);
}
