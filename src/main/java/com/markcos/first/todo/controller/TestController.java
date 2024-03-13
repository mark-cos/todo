package com.markcos.first.todo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="testController", description = "Test API")
public class TestController {

    @RequestMapping("/api/test")
    @Operation(summary = "API 테스트", description = "Swagger 테스트를 위한 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success test"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public String getTest() {
        return "test";
    }
}
