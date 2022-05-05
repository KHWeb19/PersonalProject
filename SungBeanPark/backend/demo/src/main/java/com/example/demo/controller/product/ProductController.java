package com.example.demo.controller.product;



import com.example.demo.controller.request.ProductRequest;
import com.example.demo.entity.product.Product;
import com.example.demo.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public void productRegister(@Validated Product product, @RequestParam(required = false)MultipartFile file) throws Exception {
        log.info("productRegister()" + file);

        productService.register(product,file);
    }

    @GetMapping("/list")
    public List<Product> list () {
        log.info("list()");

        return productService.list();
    }



    @GetMapping("/{productId}")
    public Product read (
            @PathVariable("productId") Long productId) {
        log.info("read()" + productId);

        return productService.read(productId);
    }


    @PutMapping("/{productId}")
    public Product productModify(
            @PathVariable("productId") Long productId, Product product,@RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("productModify() " + productId + " "+ product.getFileName());

        product.setProductId(Long.valueOf(productId));
        productService.modify(product,file);


        return product;
    }

    @DeleteMapping("/{productId}")
    public void productRemove(
            @PathVariable("productId") Long productId, Product product) throws Exception {
        log.info("productRemove()" + productId);

        productService.remove(productId);
    }
}
