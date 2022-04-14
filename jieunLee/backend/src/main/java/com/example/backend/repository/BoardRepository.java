package com.example.backend.repository;

import com.example.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Transactional
    @Query("select b from Board b where b.memberNo = :memberNo")
    public List<Board> selectMyBoard(Long memberNo);
}
