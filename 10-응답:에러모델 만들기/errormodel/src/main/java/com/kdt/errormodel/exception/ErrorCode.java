package com.kdt.errormodel.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SERVER_ERROR(5000);

    private final int code;
    ErrorCode(int code) {
        this.code = code;
    }
}
