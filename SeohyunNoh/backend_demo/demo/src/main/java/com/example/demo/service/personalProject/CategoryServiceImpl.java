package com.example.demo.service.personalProject;

import com.example.demo.entity.personalProject.Category;
import com.example.demo.repository.personalProject.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void editCategory(int categoryId, Category updateCategory) {
        Category category = categoryRepository.getById(categoryId);

        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());

        categoryRepository.save(category);
    }

    @Override
    public boolean findById(int categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
}

