package com.markcos.first.todo.Entity;

import javax.persistence.*;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private Long password;

    @Column(name = "file")
    private String file;

    @Column(name = "theme")
    private String theme;

    @Column(name = "font")
    private String font;

    @Column(name = "language")
    private String language;
}
