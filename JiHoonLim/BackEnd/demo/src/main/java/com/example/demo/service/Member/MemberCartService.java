package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberCartRequest;
import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;

import java.util.List;

public interface MemberCartService {
    public boolean register(MemberCart memberCart, Long boardNo);
    List<FoodBoard> findFood(Long memberNo);

    /*
    public boolean addMyFood(MemberCartRequest memberCartRequest);
    public List<MemberCart> myCartList(Long memberNo);
    public void remove(Long cartNo);
     */
}
