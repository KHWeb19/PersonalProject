package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberCartRequest;
import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import com.example.demo.repository.Member.MemberCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberCartServiceImpl implements MemberCartService {

    @Autowired
    MemberCartRepository memberCartRepository;

    @Autowired
    FoodBoardRepository foodBoardRepository;

    @Override
    public boolean register(MemberCart memberCart, Long boardNo) {
        Optional<FoodBoard> findBoard = foodBoardRepository.findById(boardNo);
        log.info("getBoardNo: " + memberCart);

        memberCart.setFoodBoard(findBoard.get());

        if (memberCartRepository.findBoardNoByMemberNoAndFoodBoardBoardNo(memberCart.getMemberNo(), boardNo).isEmpty()) {
            memberCartRepository.save(memberCart);
            return true;
        }
        return false;


    }

    @Override
    public List<FoodBoard> findFood(Long memberNo) {
        List<FoodBoard> foodList = foodBoardRepository.findFoodBoardListByMemberCart(memberNo);

        return foodList;
    }

    @Override
    public void remove(Long cartNo) {
        memberCartRepository.deleteById(cartNo);
    }

}
    /*

    @Override
    public boolean addMyFood(MemberCartRequest memberCartRequest) {

        if (memberCartRepository.findBoardNoByMemberNoAndBoardNo(memberCartRequest.getMemberNo(),memberCartRequest.getBoardNo()).isEmpty()){


            MemberCart memberCart = new MemberCart(memberCartRequest.getCartNo(), memberCartRequest.getMemberNo(),memberCartRequest.getBoardNo(),memberCartRequest.getName(),memberCartRequest.getWriter(),memberCartRequest.getDes(),memberCartRequest.getKind(),memberCartRequest.getMat(),memberCartRequest.getWay(),memberCartRequest.getFilename(),memberCartRequest.getFilepath());

            memberCartRepository.save(memberCart);

            return true;
        }
        return false;


    }

    @Override
    public List<MemberCart> myCartList(Long memberNo) {

        return memberCartRepository.findCartList(memberNo);
    }

    @Override
    public void remove(Long cartNo) {
        memberCartRepository.deleteById(cartNo);
    }

     */

