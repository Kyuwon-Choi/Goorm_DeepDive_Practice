package com.kdt.errormodel.exception;

import com.kdt.errormodel.response.ApiResponse;
import com.kdt.errormodel.response.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException e) {
        ApiResponse<Void> response = new ApiResponse<>(
                new Status(e.getErrorCode().getCode(), e.getMessage()),
                null, null, e.getData()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
