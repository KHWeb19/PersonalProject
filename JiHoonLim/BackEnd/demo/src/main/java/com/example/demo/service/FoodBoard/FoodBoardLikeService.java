package com.example.demo.service.FoodBoard;

import com.example.demo.entity.Member.Member;

public interface FoodBoardLikeService {
    public boolean addLike(String member, Long boardNo);
}
