package com.kdt.responsemodel.exception;

import com.kdt.responsemodel.response.ApiResponse;
import com.kdt.responsemodel.response.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Object>> handleCustomException(CustomException ex) {
        Map<String, String> data = ((InputRestriction) ex.getData()).getInputRestriction();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(
                        new Status(ex.getErrorCode().getCode(), ex.getErrorCode().getMessage()),
                        null,
                        null,
                        Map.of("inputRestriction", data)
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception e) {
        ApiResponse<Void> response = ApiResponse.makeErrorResponse(
                ErrorCode.SERVER_ERROR.getCode(),
                ErrorCode.SERVER_ERROR.getMessage(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
