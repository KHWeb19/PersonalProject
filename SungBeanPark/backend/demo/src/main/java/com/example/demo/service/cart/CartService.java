package com.example.demo.service.cart;

import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.product.Product;

import java.util.List;

public interface CartService {
    public boolean addToCart(Cart cart, Long productId);
    List<Product> findProduct(Long memberNo);
    public void cartRemove(Long cartNo);
}
