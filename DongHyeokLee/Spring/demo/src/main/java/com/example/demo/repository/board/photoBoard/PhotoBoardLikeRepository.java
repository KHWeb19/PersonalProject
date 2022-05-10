package com.example.demo.repository.board.photoBoard;

import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PhotoBoardLikeRepository  extends JpaRepository<PhotoBoardLike, Long> {

    @Transactional
    @Query("select m from PhotoBoardLike m where m.writer = :writer")
    List<PhotoBoardLike> findByWriter(@Param("writer")String writer);

    @Query("select m from PhotoBoardLike m join m.photoBoard tb where tb.boardNo = :boardNo and m.writer = :writer")
    Optional<PhotoBoardLike> findId(@Param("boardNo")Long boardNo, @Param("writer")String writer);

    @Query("select m from PhotoBoardLike m where m.photoBoard.boardNo = :boardNo")
    List<PhotoBoardLike> findByBoardNo(@Param("boardNo")Long boardNo);





}
