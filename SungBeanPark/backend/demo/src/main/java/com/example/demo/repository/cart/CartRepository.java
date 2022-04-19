package com.example.demo.repository.cart;

import com.example.demo.entity.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select BL from Cart BL where BL.memberNo = :memberNo")
    List<Cart> findCartList(@Param("memberNo")Long memberNo);
}
