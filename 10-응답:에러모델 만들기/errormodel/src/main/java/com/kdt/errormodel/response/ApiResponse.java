package com.kdt.errormodel.response;

import java.util.List;

public class ApiResponse<T> {

    public ApiResponse(Status status, Metadata metadata, T results, Object data) {
    }

    public static <T> ApiResponse<T> makeResponse(T result) {
        return new ApiResponse<>(new Status(2000, "OK"), new Metadata(1), result, null);
    }

    public static <T> ApiResponse<List<T>> makeResponse(List<T> results) {
        return new ApiResponse<>(new Status(2000, "OK"), new Metadata(results.size()), results, null);
    }
}
