package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> registerUser(UserDto userDto);

    ResponseEntity<Object> loginUser(UserDto userDto);
}
