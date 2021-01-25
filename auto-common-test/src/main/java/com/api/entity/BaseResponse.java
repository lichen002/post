package com.api.entity;

import lombok.Data;

@Data
public class BaseResponse<T>{

    private int code;

    private String message;

    private String requestId;

    private T data;

    public BaseResponse(){}

    public BaseResponse(int code, String message, String requestId) {
        this.code = code;
        this.message = message;
        this.requestId = requestId;
    }

    public BaseResponse(int code, String message, String requestId, T data) {
        this.code = code;
        this.message = message;
        this.requestId = requestId;
        this.data = data;
    }
}
