package com.thinkon.exercise.UserService.exception;

public class ThinkOnGenericException extends RuntimeException {

    Integer code;
    String detail;

    public ThinkOnGenericException(Integer code, String detail) {
        super(detail);
        this.code = code;
        this.detail = detail;
    }

}
