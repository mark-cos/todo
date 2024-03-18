package com.markcos.first.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private Integer password;

    @Column(name = "file")
    private String file;

    @Column(name = "theme")
    private String theme;

    @Column(name = "font")
    private String font;

    @Column(name = "language")
    private String language;
}
