package com.challenge.michelfreitas.challenge.shared.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private Object result;
    private String message;
    private boolean success;

    public ApiResponse(Object result) {
        this.result = result;
        this.message = "";
        this.success = true;
    }

    public ApiResponse(Object result, String message) {
        this.result = result;
        this.message = message;
        this.success = true;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.result = null;
    }
}