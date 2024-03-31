package com.markcos.first.todo.service;

import com.markcos.first.todo.dto.UserDto;
import com.markcos.first.todo.dto.LoginDto;
import com.markcos.first.todo.entity.UserEntity;
import com.markcos.first.todo.repository.UserRepository;
import com.markcos.first.todo.utils.Encryption;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private static final Key ACCESS_TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final Key REFRESH_TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long ACCESS_TOKEN_EXPIRATION_MS = 3600000; // 1시간
    private static final long REFRESH_TOKEN_EXPIRATION_MS = 86400000; // 1일

    @Override
    public void registerUser(UserDto userDto) throws Exception {
        if(userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty() || userDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid");
        }

        userRepository.save(toEntity(userDto));
    }

    @Override
    public LoginDto loginUser(UserDto userDto) throws Exception {
        UserDto user = fromEntity(userRepository.findByEmailAndPassword(userDto.getEmail(), Encryption.encrypt(userDto.getPassword())));
        String accessToken = getAccessToken(user.getEmail());
        String refreshToken = getRefreshToken(user.getEmail());

        return new LoginDto(
                accessToken,
                refreshToken,
                user.getEmail(),
                user.getName(),
                user.getFont(),
                user.getFile(),
                user.getLanguage(),
                user.getTheme()
        );
    }

    public String getAccessToken(String subject){
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_MS))
                .signWith(ACCESS_TOKEN_KEY)
                .compact();
    }

    public static String getRefreshToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_MS))
                .signWith(REFRESH_TOKEN_KEY)
                .compact();
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
