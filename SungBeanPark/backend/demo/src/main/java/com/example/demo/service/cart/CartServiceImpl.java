package com.example.demo.service.cart;


import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.product.Product;
import com.example.demo.repository.cart.CartRepository;
import com.example.demo.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean addToCart(Cart cart, Long productId) {
        Optional<Product> findProduct = productRepository.findById(productId);
        log.info("getProductId: " + cart);

        cart.setProduct(findProduct.get());

        if (cartRepository.findProductIdByMemberNoAndProductProductId(cart.getMemberNo(), productId).isEmpty()) {
            cartRepository.save(cart);
            return true;
        }
        return false;

    }

    @Override
    public List<Product> findProduct(Long memberNo) {
        List<Product> productList = productRepository.findProductListByCart(memberNo);

        return productList;
    }

    @Override
    public void cartRemove(Long cartNo) {
        cartRepository.deleteById(cartNo);
    }


}

