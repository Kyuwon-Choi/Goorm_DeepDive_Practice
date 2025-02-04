package com.kdt.responsemodel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kdt.responsemodel.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private int code;
    private String message;

    public Status(ErrorCode errorCode, String message) {
        this.code = errorCode.getCode();
        this.message = message;
    }
}
