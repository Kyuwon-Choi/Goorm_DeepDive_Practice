package com.kdt.responsemodel.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_GRADE(500, "grade 는 6 이상을 입력 할 수 없습니다."),
    SERVER_ERROR(5000, "Internal Server Error");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
