package com.vti.configuration.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// định dạng lỗi
public class ErrorResponse {
    private int code;
    private String message;
    private Object errors;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public ErrorResponse(int code, String message, Object errors) {
        this(code, message);
        this.errors = errors;
    }
}
