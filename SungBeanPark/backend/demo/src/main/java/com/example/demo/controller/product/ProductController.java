package com.example.demo.controller.product;



import com.example.demo.entity.product.Product;
import com.example.demo.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Void> register (@Validated @RequestBody Product product) throws  Exception{

        productService.register(product);
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("getProductList")
    public ResponseEntity<List<Product>> getProductList() throws  Exception {
        productService.getProductList();

        return new ResponseEntity<>(productService.getProductList(),HttpStatus.OK);
    }
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Product> getProduct (@PathVariable("productId") Long productId) throws  Exception {

        Optional<Product> product = productService.getProduct(productId);
        Product product1  = product.get();
        return new ResponseEntity<>(product1,HttpStatus.OK);
    }


}
