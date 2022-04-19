package com.example.demo.service.product;

import com.example.demo.entity.product.Product;
import com.example.demo.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void register(Product product) throws  Exception {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductList() throws Exception {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long productId) throws Exception {
        return productRepository.findById(productId);
    }
}
