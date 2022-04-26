package com.example.demo.controller.personalProject;

import com.example.demo.common.ApiResponse;
import com.example.demo.controller.request.AddToCartDto;
import com.example.demo.controller.request.CartDto;
import com.example.demo.controller.request.CartItemDto;
import com.example.demo.entity.personalProject.Cart;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.service.personalProject.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    private HttpSession session;


    // 장바구니 담기
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto) throws Exception {
        log.info("add to cart()");

//      Member getMember = (Member) session.getAttribute("member");
//      addToCartDto.setMemberId(getMember.getId()); // 멤버 세팅

        cartService.addToCart(addToCartDto);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }


    // 장바구니 리스트 가져오기
    @GetMapping("/list")
    public ResponseEntity<CartDto> getCartItems() throws Exception {
        log.info("get cart list()");

        Object member = session.getAttribute("member");

        if(member != null){
            CartDto cartDto = cartService.listCartItems((Member) member);
            return new ResponseEntity<>(cartDto, HttpStatus.OK);
        }

        CartDto cartDtoNull = cartService.listCartItems(null);
        return new ResponseEntity<>(cartDtoNull, HttpStatus.BAD_REQUEST);
    }

    // 장바구니 삭제
}
