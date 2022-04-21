package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.FoodBoard.FoodBoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodBoardLikeRepository  extends JpaRepository<FoodBoardLike, Long> {
    Optional<FoodBoardLike> findByMemberAndFoodBoard(String member, FoodBoard foodBoard);
}
