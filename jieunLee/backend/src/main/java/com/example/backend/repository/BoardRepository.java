package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Transactional
//    @Query("select b from Board b where b.memberNo = :memberNo")
//    public List<Board> selectMyBoard(Long memberNo);

    @Query("select b from Board b join b.member m where m.memberNo = :memberNo")
    List<Board> findBoardByMemberNo(@Param("memberNo") Long memberNo);
}
