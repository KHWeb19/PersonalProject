package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
