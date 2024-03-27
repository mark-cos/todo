package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.UserDto;
import com.markcos.first.todo.entity.UserEntity;
import com.markcos.first.todo.repository.UserRepository;
import com.markcos.first.todo.utils.Encryption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void registerUser(UserDto userDto) throws Exception {
        if(userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty() || userDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid");
        }

        userRepository.save(toEntity(userDto));
    }

    @Override
    public UserDto loginUser(UserDto userDto) throws Exception {
        return fromEntity(userRepository.findByEmailAndPassword(userDto.getEmail(), Encryption.encrypt(userDto.getPassword())));
    }

    private UserEntity toEntity(UserDto userDto) throws Exception {
        return new UserEntity(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                Encryption.encrypt(userDto.getPassword()),
                userDto.getFile(),
                userDto.getTheme(),
                userDto.getFont(),
                userDto.getLanguage()
        );
    }

    private UserDto fromEntity(UserEntity entity) {
        return new UserDto(
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getFile(),
            entity.getTheme(),
            entity.getFont(),
            entity.getLanguage()
        );
    }
}
