package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByMemberAndBoard (Member member, Board board);

    @Query(value = "select * from likes where board_no in(select board_no from board where board_no = :boardNo) and member_no in(select member_no from member where member_no = :memberNo)", nativeQuery = true)
    List<Likes> findByBoardNoAndMemberNo(@Param("boardNo") Long boardNo, @Param("memberNo") Long memberNo);

    @Query(value = "select * from likes where board_no in(select board_no from board where board_no = :boardNo)", nativeQuery = true)
    List<Likes> findByBoardNo(@Param("boardNo") Long boardNo);

    Optional<Likes> findByBoard (Board board);

//    @Query(value = "select * from likes where member_no in(select member_no from member where member_no = :memberNo)", nativeQuery = true)
//    List<Likes> findAllByMemberNo(@Param("memberNo") Long memberNo);

//    @Query("select count(l) from Likes l where l.board = :boardNo")
//    Optional<Likes> findCountLikesByBoardNo(Long boardNo);


}
