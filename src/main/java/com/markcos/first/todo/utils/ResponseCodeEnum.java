package com.markcos.first.todo.utils;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {
    OK("OK", 200),
    FAIL("FAIL", 900);

    private final String name;
    private final int value;

    ResponseCodeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

}
