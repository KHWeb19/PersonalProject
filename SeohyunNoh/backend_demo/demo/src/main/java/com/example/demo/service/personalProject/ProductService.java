package com.example.demo.service.personalProject;

import com.example.demo.controller.request.ProductDto;
import com.example.demo.entity.personalProject.Category;
import com.example.demo.entity.personalProject.Product;
import com.example.demo.exceptions.ProductNotExistsException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProductService {

    public void createProduct(ProductDto productDto, Category category);

    public ProductDto getProductDto(Product product);

    public List<ProductDto> getAllProducts();

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception;

    public Product findById(Integer productId) throws ProductNotExistsException;

    public void remove(Integer productId);
}
