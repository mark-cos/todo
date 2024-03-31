package com.markcos.first.todo.service;

import com.markcos.first.todo.entity.Category;
import com.markcos.first.todo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Category category) {
        Category newCategory = categoryRepository.findById(category.getId()).orElse(null);
        if (newCategory == null) {
            return;
        } else {
        newCategory.setName(category.getName());
            newCategory.setColor(category.getColor());
            newCategory.setIcon(category.getIcon());
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(Long.valueOf(id));
    }


}
