package com.example.demo.controller.personalProject;

import com.example.demo.common.ApiResponse;
import com.example.demo.entity.personalProject.Category;
import com.example.demo.service.personalProject.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);

        log.info("create category()");

        return new ResponseEntity<>(new ApiResponse(true, "create a new category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category) {

        if(!categoryService.findById(categoryId)) {
            log.info("category does not exist");
           return new ResponseEntity<>(new ApiResponse(false,"category does not exist"), HttpStatus.NOT_FOUND);
       }

        categoryService.editCategory(categoryId,category);

        log.info("update category");

        return new ResponseEntity<>(new ApiResponse(true,"category has been updated"), HttpStatus.OK);
    }
}
