package com.example.demo.service.product;

import com.example.demo.entity.product.ProductComment;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductCommentService {
    public void register(ProductComment productComment, Long productId, @RequestParam(required = false) MultipartFile file) throws Exception;

    public List<ProductComment> list (Long productId);

    public void delete (Long commentNo);
}
