package com.example.demo.repository.cart;

import com.example.demo.entity.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findProductIdByMemberNoAndProductProductId(Long memberNo, Long productId);

    @Transactional
    @Query("select cl from Cart cl where cl.memberNo = :memberNo")
    List<Cart> findCartList(@Param("memberNo")Long memberNo);

}
