package com.example.demo.service.personalProject;

import com.example.demo.entity.personalProject.Category;

import java.util.List;

public interface CategoryService {

    public void createCategory(Category category);
    public List<Category> listCategory();
    public void editCategory(int categoryId, Category category);
    public boolean findById(int categoryId);
}
