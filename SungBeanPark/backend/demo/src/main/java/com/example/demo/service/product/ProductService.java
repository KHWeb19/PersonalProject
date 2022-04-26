package com.example.demo.service.product;

import com.example.demo.controller.request.ProductRequest;
import com.example.demo.entity.product.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void register (Product product, @RequestParam(required = false)MultipartFile file) throws IOException,Exception;
    public List<Product> list();

    public Product read(Long productId);

    public void modify (Product product, @RequestParam(required = false)MultipartFile file) throws Exception;
    public void remove(Long productId) throws Exception;
}

