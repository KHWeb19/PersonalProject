package com.example.demo.service.personalProject;

import com.example.demo.controller.request.ProductDto;
import com.example.demo.entity.personalProject.Category;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductDto productDto, Category category);

    public List<ProductDto> getAllProducts();

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception;
}
