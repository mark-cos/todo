package com.markcos.first.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "file")
    private String file;

    @Column(name = "theme")
    private String theme;

    @Column(name = "font")
    private String font;

    @Column(name = "language")
    private String language;

    public UserEntity(Integer id, String name, String email, String password, String file, String theme, String font, String language) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.file = file;
        this.theme = theme;
        this.font = font;
        this.language = language;
    }

    protected UserEntity() {}
}
