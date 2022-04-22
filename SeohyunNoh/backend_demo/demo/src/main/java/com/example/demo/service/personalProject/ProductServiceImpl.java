package com.example.demo.service.personalProject;

import com.example.demo.controller.request.ProductDto;
import com.example.demo.entity.personalProject.Category;
import com.example.demo.entity.personalProject.Product;
import com.example.demo.repository.personalProject.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageURl(productDto.getImageURl());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());

        productRepository.save(product);
    }

    public ProductDto getProductDto (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageURl(product.getImageURl());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        product.setId(product.getId());

        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    @Override
    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()) {
            throw new Exception("product is not present");
        }

        Product product = optionalProduct.get();

        product.setDescription(productDto.getDescription());
        product.setImageURl(productDto.getImageURl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);
    }
}
