package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query(value = "select * from board where member_no in(select member_no from member where member_no = :memberNo)", nativeQuery = true)
    List<Board> findAllByMemberNo(@Param("memberNo") Long memberNo);

    @Query("select b from Board b join b.member bm where bm.memberNo = :memberNo")
    List<Board> findAllBoardsMemberNo(@Param("memberNo") Long memberNo);

//    List<Board> findByMemberByMemberNo(@Param("memberNo") Long memberNo);
}
