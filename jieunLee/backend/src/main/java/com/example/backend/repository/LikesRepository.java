package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByMemberAndBoard (Member member, Board board);

//    @Query("select count(l) from Likes l where l.board = :boardNo")
//    Optional<Likes> findCountLikesByBoardNo(Long boardNo);


}
