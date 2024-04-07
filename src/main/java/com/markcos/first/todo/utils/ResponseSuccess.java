package com.markcos.first.todo.utils;

import lombok.Data;

@Data
public class ResponseSuccess {
    private int id;
    private String email;
    private String title;
    private Object data;

    public ResponseSuccess(int id, String email, String title, Object data) {
        this.id = id;
        this.email = email;
        this.title = title;
        this.data = data;
    }
}
