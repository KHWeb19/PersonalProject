package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
//    Optional<Likes> findByMemberNoAndBoard (Long memberNo, Board board);



}
