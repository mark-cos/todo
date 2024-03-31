package com.markcos.first.todo.controller;

import com.markcos.first.todo.dto.LoginDto;
import com.markcos.first.todo.dto.UserDto;
import com.markcos.first.todo.entity.UserEntity;
import com.markcos.first.todo.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name="UserController", description = "user API")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public void getCategory(@RequestBody UserDto userDto) throws Exception {
        userService.registerUser(userDto);
    }

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public LoginDto getLogin(@RequestBody UserDto userDto) throws Exception {
        return userService.loginUser(userDto);
    }
}
