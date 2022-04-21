package com.example.demo.controller.personalProject;

import com.example.demo.common.ApiResponse;
import com.example.demo.controller.request.ProductDto;
import com.example.demo.entity.personalProject.Category;
import com.example.demo.entity.personalProject.Product;
import com.example.demo.repository.personalProject.CategoryRepository;
import com.example.demo.service.presonalProject.ProductService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProducts () {
        List<ProductDto> products = productService.getAllProducts();

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto, productId);
        return new ResponseEntity<>(new ApiResponse(true,"product has been updated"), HttpStatus.OK);
    }
}
