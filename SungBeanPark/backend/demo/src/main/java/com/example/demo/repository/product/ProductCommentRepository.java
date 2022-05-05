package com.example.demo.repository.product;

import com.example.demo.entity.product.Product;
import com.example.demo.entity.product.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findProductCommentByProduct(Product product);
}
