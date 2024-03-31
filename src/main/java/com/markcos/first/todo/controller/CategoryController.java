package com.markcos.first.todo.controller;

import com.markcos.first.todo.entity.Category;
import com.markcos.first.todo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="CategoryController", description = "Category API")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "카테고리 리스트 조회", description = "카테고리 리스트를 조회하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<Category> getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        return categoryList;
    }

    @GetMapping("/categories/{id}")
    @Operation(summary = "카테고리 조회", description = "카테고리를 이름으 조회하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public Category getCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getCategory(id);
        return category.orElse(null);
    }

    @PostMapping("/categories")
    @Operation(summary = "카테고리 추가하기", description = "카테고리를 추가하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public void insertCategory(Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/categories")
    @Operation(summary = "카테고리 수정하기", description = "카테고리를 수정하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public void updateCategory(Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    @Operation(summary = "카테고리 삭제", description = "카테고리를 삭제하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
