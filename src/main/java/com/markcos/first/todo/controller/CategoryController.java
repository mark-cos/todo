package com.markcos.first.todo.controller;

import com.markcos.first.todo.entity.Category;
import com.markcos.first.todo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name="CategoryController", description = "Category API")
@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{name}")
    @Operation(summary = "카테고리 리스트 조회", description = "카테고리 리스트를 조회하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public Category getCategory(@PathVariable String name) {
        Optional<Category> category = categoryService.getCategory(name);
        return category.orElse(null);
    }



}
