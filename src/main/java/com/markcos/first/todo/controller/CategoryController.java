package com.markcos.first.todo.controller;

import com.markcos.first.todo.Entity.Category;
import com.markcos.first.todo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="CategoryController", description = "Category API")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getCategories")
    @Operation(summary = "카테고리 리스트 조회", description = "카테고리 리스트를 조회하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public Category getCategory(@RequestBody String name) {
        Optional<Category> category = categoryService.getCategory(name);
        if (category.isPresent()) {
            return category.get();
        } else {
            return null;
        }
    }



}
