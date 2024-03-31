package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.LoginDto;
import com.markcos.first.todo.dto.UserDto;

public interface UserService {
    void registerUser(UserDto userDto) throws Exception;

    LoginDto loginUser(UserDto userDto) throws Exception;
}
