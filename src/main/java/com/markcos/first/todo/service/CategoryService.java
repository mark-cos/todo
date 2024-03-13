package com.markcos.first.todo.service;

import com.markcos.first.todo.Entity.Category;
import com.markcos.first.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategory(String name) {
        return categoryRepository.findByName(name);
    }
}
