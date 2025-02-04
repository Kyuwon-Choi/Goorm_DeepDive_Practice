package com.kdt.responsemodel.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ApiResponse<T> {
    private final Status status;
    private final Metadata metadata;
    private final T results;
    private final Object data;

    public ApiResponse(Status status, Metadata metadata, T results, Object data) {
        this.status = status;
        this.metadata = metadata;
        this.results = results;
        this.data = data;
    }

    public static <T> ApiResponse<T> makeResponse(T result) {
        int count = (result instanceof List<?>) ? ((List<?>) result).size() : 1;
        return new ApiResponse<>(new Status(2000, "OK"), new Metadata(count), result, null);
    }


    public static <T> ApiResponse<T> makeErrorResponse(int code, String message, Object data) {
        return new ApiResponse<>(new Status(code, message), new Metadata(0), null, data); // Metadata 추가
    }
}
