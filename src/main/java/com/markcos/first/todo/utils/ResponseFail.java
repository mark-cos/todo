package com.markcos.first.todo.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseFail {
    private String message;
    private int code;

    public ResponseFail(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
