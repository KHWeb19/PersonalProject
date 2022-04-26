package com.example.demo.service.product;

import com.example.demo.entity.product.Product;
import com.example.demo.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void register(Product product, MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("C:\\Project\\PersonalProject\\SungBeanPark\\frontend\\src\\assets\\image" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            product.setFileName(fileName);
            product.setFilePath("/files/" + fileName);
        }

        productRepository.save(product);
    }


    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }


    @Override
    public Product read(Long productId) {
        Optional<Product> maybeReadProduct = productRepository.findById(Long.valueOf(productId));

        if (maybeReadProduct.equals(Optional.empty())) {
            return null;
        }
        log.info("info " + maybeReadProduct);
        return maybeReadProduct.get();
    }

    @Override
    public void modify(Product product, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("fileName: " + product.getFileName());

        if (!product.getFileName().isEmpty()) {
            Path filePath = Paths.get("C:\\Project\\PersonalProject\\SungBeanPark\\frontend\\src\\assets\\image" + product.getFileName());
            Files.delete(filePath);
        }

        if (file != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("C:\\Project\\PersonalProject\\SungBeanPark\\frontend\\src\\assets\\image" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            product.setFileName(fileName);
            product.setFilePath("/files/" + fileName);
        }

        productRepository.save(product);
    }



    @Override
    public void remove(Long productId) throws Exception {
        Optional<Product> selectFile = productRepository.findById(Long.valueOf(productId));
        Product deleteFile = selectFile.get();

        if (deleteFile.getFileName() != null) {
            Path filePath = Paths.get("C:\\Project\\PersonalProject\\SungBeanPark\\frontend\\src\\assets\\image" + deleteFile.getFileName());
            Files.delete(filePath);
        }
        productRepository.deleteById(Long.valueOf(productId));
    }
}
