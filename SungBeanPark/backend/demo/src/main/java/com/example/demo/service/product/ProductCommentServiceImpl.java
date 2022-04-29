package com.example.demo.service.product;

import com.example.demo.entity.product.Product;
import com.example.demo.entity.product.ProductComment;
import com.example.demo.repository.product.ProductCommentRepository;
import com.example.demo.repository.product.ProductRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCommentRepository commentRepository;

    @SneakyThrows
    @Override
    public void register(ProductComment productComment, Long productId, @RequestParam(required = false) MultipartFile file) throws Exception{
        Optional<Product> findProduct = productRepository.findById(productId);
        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("C:\\Project\\PersonalProject\\SungBeanPark\\frontend\\src\\assets\\image" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            productComment.setFileName(fileName);
        }

        productComment.setProduct(findProduct.get());
        commentRepository.save(productComment);
    }

    @Override
    public List<ProductComment> list (Long productId) {
        Product product = productRepository.findById(productId).get();
        return commentRepository.findProductCommentByProduct(product);
    }

    @Override
    public void delete(Long commentNo) {
        commentRepository.deleteById(Long.valueOf(commentNo));
    }
}
