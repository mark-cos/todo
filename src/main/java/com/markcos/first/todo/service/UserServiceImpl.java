package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.LoginDto;
import com.markcos.first.todo.dto.UserDto;
import com.markcos.first.todo.entity.UserEntity;
import com.markcos.first.todo.repository.UserRepository;
import com.markcos.first.todo.utils.Encryption;
import com.markcos.first.todo.utils.ResponseFail;
import com.markcos.first.todo.utils.ResponseSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.markcos.first.todo.utils.TokenProvider.getAccessToken;
import static com.markcos.first.todo.utils.TokenProvider.getRefreshToken;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<Object> registerUser(UserDto userDto) {
        if(userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty() || userDto.getName().isEmpty()) {
            return new ResponseEntity<>(new ResponseFail("필수 항복이 비어있습니다", 900), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        try {
            UserEntity userEntity = userRepository.save(toEntity(userDto));
            return new ResponseEntity<>(new ResponseSuccess(userEntity.getId(), userEntity.getEmail(), "", userEntity), HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(new ResponseFail("실패했습니다.", 900), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> loginUser(UserDto userDto) {
        try {
            UserDto user = fromEntity(userRepository.findByEmailAndPassword(userDto.getEmail(), Encryption.encrypt(userDto.getPassword())));
            if(user == null) {
                return new ResponseEntity<>(new ResponseFail("회원 정보가 없습니다", 900), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String accessToken = getAccessToken(user.getEmail());
            String refreshToken = getRefreshToken(user.getEmail());

            LoginDto loginInfo = new LoginDto(
                    accessToken,
                    refreshToken,
                    user.getEmail(),
                    user.getName(),
                    user.getFont(),
                    user.getFile(),
                    user.getLanguage(),
                    user.getTheme()
            );

            return new ResponseEntity<>(new ResponseSuccess(user.getId(), user.getEmail(), "", loginInfo), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseFail("실패했습니다", 900), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        if(entity == null) {
            return null;
        }

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
