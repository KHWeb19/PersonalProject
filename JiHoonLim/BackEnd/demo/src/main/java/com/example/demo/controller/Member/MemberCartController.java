package com.example.demo.controller.Member;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.service.Member.MemberCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/myCart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberCartController {

    @Autowired
    private MemberCartService service;

    @PostMapping("/register/{boardNo}")
    public boolean register(@Validated @RequestBody MemberCart memberCart, @PathVariable("boardNo") Long boardNo){
        log.info("register() " +memberCart);

        return service.register(memberCart, boardNo);
    }

    @GetMapping("/list/{memberNo}")
    public List<FoodBoard> list(@PathVariable("memberNo")Long memberNo){
        log.info("memberCartList()");

        List<FoodBoard> findFood =service.findFood(memberNo);


        return findFood;
    }
    @DeleteMapping("/delete/{cartNo}")
    public void myCartRemove(@PathVariable("cartNo")Long cartNo){
        log.info("myCartRemove()" +cartNo);

        service.remove(cartNo);
    }

    /*
    @PostMapping("/register/{memberNo}")
    public boolean addMyCart(@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberCartRequest memberCartRequest){
        log.info("addCart" +memberCartRequest);

        memberCartRequest.setMemberNo(memberNo);

        return service.addMyFood(memberCartRequest);
    }


    @GetMapping("/list/{memberNo}")
    public List<MemberCart> memberCartList(@PathVariable("memberNo")Long memberNo){
        log.info("memberCartList()");

        return service.myCartList(memberNo);
    }

    @DeleteMapping("/delete/{cartNo}")
    public void myCartRemove(@PathVariable("cartNo")Long cartNo){
        log.info("myCartRemove()");

        service.remove(cartNo);
    }

     */
}
