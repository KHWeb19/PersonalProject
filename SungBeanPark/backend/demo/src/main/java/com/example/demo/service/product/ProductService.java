package com.example.demo.service.product;

import com.example.demo.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public  void register (Product product)throws  Exception;

    public List<Product> getProductList() throws  Exception;

    public Optional<Product> getProduct(Long productId) throws Exception;
}
