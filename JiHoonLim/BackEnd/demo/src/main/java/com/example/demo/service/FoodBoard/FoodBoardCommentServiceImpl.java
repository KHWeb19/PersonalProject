package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.FoodBoard.FoodBoardComment;
import com.example.demo.repository.FoodBoard.FoodBoardCommentRepository;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FoodBoardCommentServiceImpl implements FoodBoardCommentService{

    @Autowired
    FoodBoardRepository foodBoardRepository;

    @Autowired
    FoodBoardCommentRepository commentRepository;

    @Override
    public void register(FoodBoardComment foodBoardComment, Long boardNo) {
        Optional<FoodBoard> findBoard = foodBoardRepository.findById(boardNo);

        foodBoardComment.setFoodBoard(findBoard.get());
        commentRepository.save(foodBoardComment);
    }

    @Override
    public List<FoodBoardComment> list(Long boardNo) {
        FoodBoard foodBoard = foodBoardRepository.findById(boardNo).get();

        return commentRepository.findFoodBoardCommentByFoodBoard(foodBoard);
    }

    @Override
    public void delete(Long commentNo) {
        commentRepository.deleteById(Long.valueOf(commentNo));
    }


}
