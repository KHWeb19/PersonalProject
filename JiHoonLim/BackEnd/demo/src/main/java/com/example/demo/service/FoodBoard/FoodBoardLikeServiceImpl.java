package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.FoodBoard.FoodBoardLike;
import com.example.demo.repository.FoodBoard.FoodBoardLikeRepository;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodBoardLikeServiceImpl implements FoodBoardLikeService{

    @Autowired
    FoodBoardLikeRepository likeRepository;

    @Autowired
    FoodBoardRepository foodRepository;



    @Override
    public boolean addLike(String member, Long boardNo) {
        FoodBoard foodBoard = foodRepository.findById(boardNo).orElseThrow();

        if (likeRepository.findByMemberAndFoodBoard(member,foodBoard).isEmpty()) {
            likeRepository.save(new FoodBoardLike(foodBoard, member));
            return true;
        }
        return false;
    }

}
