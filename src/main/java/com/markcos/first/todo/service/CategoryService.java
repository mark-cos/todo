package com.markcos.first.todo.service;

import com.markcos.first.todo.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> getCategory(Integer id);

    void saveCategory(Category category);

    List<Category> getCategoryList();

    void updateCategory(Category category);

    void deleteCategory(Integer id);
}
