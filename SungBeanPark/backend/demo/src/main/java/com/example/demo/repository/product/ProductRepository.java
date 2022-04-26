package com.example.demo.repository.product;

import com.example.demo.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select j from Product j where j.productId = :productId")
    Optional<Product> findById(Long productId);
}
