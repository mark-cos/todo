package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.UserDto;

public interface UserService {
    void registerUser(UserDto userDto) throws Exception;

    UserDto loginUser(UserDto userDto) throws Exception;
}
