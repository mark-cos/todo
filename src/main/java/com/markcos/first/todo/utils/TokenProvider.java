package com.markcos.first.todo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {
    private static final Key ACCESS_TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final Key REFRESH_TOKEN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long ACCESS_TOKEN_EXPIRATION_MS = 3600000; // 1시간
    private static final long REFRESH_TOKEN_EXPIRATION_MS = 86400000; // 1일

    private TokenProvider() {}

    public static String getAccessToken(String subject){
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

    public String validateTokenAndGetSubject(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
