package com.example.demo.repository;

import com.example.demo.entity.TipBoard;
import com.example.demo.entity.TipBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipBoardLikeRepository extends JpaRepository<TipBoardLike, Long> {
    Optional<TipBoardLike> findByWhoAndTipBoard (String who, TipBoard tipBoard);
}
