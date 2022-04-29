package com.example.demo.controller.product;

import com.example.demo.entity.product.ProductComment;
import com.example.demo.service.product.ProductCommentService;
import com.example.demo.service.product.ProductService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product/comment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductCommentController {
    @Autowired
    private ProductCommentService commentService;

    @SneakyThrows
    @PostMapping("/register/{productId}")
    public void productCommentRegister(@Validated ProductComment productComment, @RequestParam(required = false) MultipartFile file, @PathVariable("productId") Long productId){
        log.info("productCommentRegister" + productComment + file);
        commentService.register(productComment, productId, file);
    }

    @GetMapping("/list/{productId}")
    public List<ProductComment> list(@PathVariable("productId")Long productId){
        log.info("commentList()");

        return commentService.list(productId);
    }

    @DeleteMapping("/delete/{commentNo}")
    public void delete(@PathVariable("commentNo") Long commentNo, ProductComment productComment){
        log.info("delete()" + commentNo);

        commentService.delete(commentNo);
    }
}
