package com.example.demo.repository.product;

import com.example.demo.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select j from Product j where j.productId = :productId")
    List<Product> findByType(@Param("productId")String productId);
}
