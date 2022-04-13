package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {
}
