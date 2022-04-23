package com.example.demo.service.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoardComment;

import java.util.List;

public interface FoodBoardCommentService {
    public void register(FoodBoardComment foodBoardComment, Long boardNo);
    public List<FoodBoardComment> list(Long boardNo);
    public void delete (Long commentNo);
}
