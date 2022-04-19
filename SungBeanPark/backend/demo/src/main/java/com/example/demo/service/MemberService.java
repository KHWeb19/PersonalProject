package com.example.demo.service;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Cart.Cart;

import java.util.List;

public interface MemberService {
    // Sign
    public void register(MemberRequest memberRequest);
    public MemberRequest login(MemberRequest memberRequest);
    public Boolean checkUserIdValidation(String id);

    // Cart
    public  void addCart(CartRequest cartRequest) throws  Exception;
    public List<Cart> getCartList(Long memberNo) throws  Exception;
    public  void ModifyProductNum(CartRequest CartRequest);
    public  void deleteProduct(Long cartId) throws  Exception;
}
