package com.markcos.first.todo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    String accessToken;
    String refreshToken;
    String email;
    String name;
    String font;
    String image;
    String language;
    String theme;
}
