package com.markcos.first.todo.service;

import com.markcos.first.todo.entity.CategoryEntity;
import java.util.Optional;

public interface CategoryService {
    Optional<CategoryEntity> getCategory(String name);
}
