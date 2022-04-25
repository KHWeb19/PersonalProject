package com.example.demo.service;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.member.Member;

import java.util.List;

public interface MemberService {

    // Sign & Login
    public void register(MemberRequest memberRequest);

    public MemberRequest login(MemberRequest memberRequest);

    public Boolean checkUserIdValidation(String id);

    public Member read(Long memberNo) ;

    public Member modify(Long memberNo, Member member);

    public void remove(Long memberNo);

    public List<Member> list();

    // Search
    public List<Member> searchName(String keyWord);


    // Cart
    public void addToCart(CartRequest cartRequest) throws Exception;

    public List<Cart> cartList(Long memberNo) throws  Exception;

}

