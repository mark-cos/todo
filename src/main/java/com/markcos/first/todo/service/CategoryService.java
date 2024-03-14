package com.markcos.first.todo.service;

import com.markcos.first.todo.entity.Category;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> getCategory(String name);
}
