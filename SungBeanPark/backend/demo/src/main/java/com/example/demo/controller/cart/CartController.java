package com.example.demo.controller.cart;


import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.product.Product;
import com.example.demo.service.cart.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CartController {

    @Autowired
    private CartService cartservice;

    @PostMapping("/addToCart/{productId}")
    public void addToCart(@Validated @RequestBody Cart cart, @PathVariable("productId") Long productId){
        log.info("register() " + cart);

        cartservice.addToCart(cart, productId);
    }

    @GetMapping("/cartList/{memberNo}")
    public List<Product> cartList(@PathVariable("memberNo")Long memberNo){
        log.info("memberCartList()");

        List<Product> findProduct = cartservice.findProduct(memberNo);


        return findProduct;
    }
    @DeleteMapping("/cartRemove/{cartNo}")
    public void cartRemove(@PathVariable("cartNo")Long cartNo){
        log.info("cartRemove()" + cartNo);

        cartservice.cartRemove(cartNo);
    }

}
