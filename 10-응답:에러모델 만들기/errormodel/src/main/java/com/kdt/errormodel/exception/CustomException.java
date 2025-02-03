package com.kdt.errormodel.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;
    private final Object data;

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

}
