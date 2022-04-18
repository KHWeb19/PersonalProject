package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.FoodBoard.FoodBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FoodBoardCommentRepository extends JpaRepository<FoodBoardComment, Long> {

    List<FoodBoardComment>findFoodBoardCommentByFoodBoard(FoodBoard foodBoard);
}
