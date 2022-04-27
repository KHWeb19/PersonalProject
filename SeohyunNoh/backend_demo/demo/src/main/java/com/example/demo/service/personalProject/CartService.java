package com.example.demo.service.personalProject;

import com.example.demo.controller.request.AddToCartDto;
import com.example.demo.controller.request.CartDto;
import com.example.demo.entity.personalProject.Member;

public interface CartService {
    public void addToCart(AddToCartDto addToCartDto) throws Exception;
    public CartDto listCartItems(Member member) throws Exception;
//    public void deleteCartItem(Integer cartItemId, Member member);
    public void deleteCartItem(Integer cartItemId);

}
